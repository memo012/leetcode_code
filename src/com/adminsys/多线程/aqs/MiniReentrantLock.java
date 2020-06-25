package com.adminsys.多线程.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: qiang
 * @Description: 模仿ReentrantLock锁
 * @Create: 2020-05-15 15-55
 **/
public class MiniReentrantLock implements Lock {

    /**
     * 重试次数
     */
    private volatile int state;

    /**
     * 独占锁
     */
    private Thread exclusiveOwnerThread;

    /**
     * 最后一个获取同步状态的node节点
     */
    private Node head;

    /**
     * 同步队列中最后一个node节点
     */
    private Node tail;

    public Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    static final class Node {
        Node prev;
        Node next;
        // 封装的线程本尊
        Thread thread;

        public Node(Thread thread) {
            this.thread = thread;
        }

        public Node() {
        }
    }

    public int getState() {
        return state;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    private void setHead(Node node) {
        this.head = node;
        // 因为当前node已经获取锁成功的线程了...
        node.prev = null;
        node.next = null;
    }

    @Override
    public void lock() {
        acquire(1);
    }

    /**
     * 竞争资源
     * 1. 尝试获取锁 成功 则 占用锁 且返回
     * 2. 抢占锁失败阻塞当前线程
     */
    private void acquire(int args) {
        // 获取锁失败
        if (!tryAcquire(args)) {
            // 抢锁失败
            // 添加到阻塞队列中
            Node node = addWaiter();
            // 抢夺资源
            acquireQueued(node, args);
        }
    }

    private void acquireQueued(Node node, int args) {
        // 抢占资源
        //只有当前node成功获取到锁 以后 才会跳出自旋
        for (; ; ) {
            Node prev = node.prev;
            if (prev == head && tryAcquire(args)) {
                //这里面，说明当前线程 竞争锁成功啦！
                //需要做点什么？
                //1.设置当前head 为当前线程的node
                //2.协助 原始 head 出队
                setHead(node);
                prev.next = null; // 出队
                return;
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "，挂起！");
            //将当前线程挂起！
            LockSupport.park();
            System.out.println("线程：" + Thread.currentThread().getName() + "，唤醒！");

            //什么时候唤醒被park的线程呢？
            //unlock 过程了！
        }

    }

    /**
     * 尝试抢占锁失败，需要做什么？
     * 1. 将当前线程封装成一个node节点，并将其添加到阻塞队列中
     * 2. 需要将当前线程park掉  处于挂起状态
     * <p>
     * 唤醒操作？
     * 1. 检查当前线程节点是否为head.next 节点
     * 2. 抢占
     * 成功：将当前node设置为head 将老的head出队操作 返回到业务层面
     * 失败：继续park，等待被唤醒...
     * ========>
     * 1. 添加到 阻塞队列的逻辑 addWaiter()
     * 2. 竞争资源的逻辑 acquireQueued()
     */

    /**
     * 当前线程入队
     * 返回当前线程对应的node节点
     * <p>
     * addWaiter() 方法执行完毕后  保证当前线程已经入队成功！
     *
     * @return
     */
    private Node addWaiter() {
        Node newNode = new Node(Thread.currentThread());
        // 队列中已经有node节点
        Node pred = tail;
        if (pred != null) {
            newNode.prev = pred;
            //条件成立：说明当前线程成功入队！
            if (compareAndSetTail(pred, newNode)) {
                pred.next = newNode;
                return newNode;
            }
        }
        // 1. cas加锁失败
        // 2. tail为空
        enq(newNode);
        return newNode;
    }

    private void enq(Node newNode) {
        for (; ; ) {
            // 队列为空
            if (tail == null) {
                //条件成立：说明当前线程 给 当前持有锁的线程 补充 head操作成功了..
                if (compareAndSetHead(new Node())) {
                    tail = head;
                }
            } else {
                //说明：当前队列中已经有node了，这里是一个追加node的过程。
                Node pred = tail;
                newNode.prev = pred;
                //条件成立：说明当前线程成功入队！
                if (compareAndSetTail(pred, newNode)) {
                    pred.next = newNode;
                    //注意：入队成功之后，一定要return。。
                    return;
                }
            }
        }
    }

    /**
     * 尝试去获取锁
     *
     * @return true 成功 false 失败
     */
    private boolean tryAcquire(int arg) {
        // 1. state == 0
        if (state == 0) {
            // 判断当前线程是否为head.next节点
            if (!hasQueuedPredecessor() && compareAndSetState(0, arg)) {
                // 抢锁成功
                this.exclusiveOwnerThread = Thread.currentThread();
                return true;
            }
        } else if (exclusiveOwnerThread == Thread.currentThread()) {
            // 2. state != 0 但是 获取锁线程是该线程
            int c = getState();
            c += arg;
            this.state = c;
            return true;
        }

        return false;
    }

    /**
     * true -> 表示当前线程前面有等待者线程
     * false -> 当前线程前面没有其他等待者线程
     *
     * @return 调用链
     * lock -> acquire -> tryAcquire -> hasQueuedPredecessor (ps: state值为0 时  即当前lock属于无主状态...)
     * <p>
     * 什么时候返回false呢？
     * 1. 当前队列为空...
     * 2. 当前线程为head.next 节点 线程   head.next在任何时候都有权利去争取一下lock
     */
    private boolean hasQueuedPredecessor() {
        Node h = head;
        Node t = tail;
        Node s;

        // 条件一： h != t
        // 成立：说明当前队列已经有node了...
        // 不成立： 1. h == t == null 2. h == t == head 第一个获取锁失败的时候，会为当前持有锁的线程 补充创建一个 head 节点

        // 条件二：前置条件：条件一成立 ((s == h.next() == null || s.thread != Thread.currentThread()))
        // 排除几种情况
        // 条件2.1 (s == h.next()) == null
        // 极端情况：第一个获取锁失败的线程，会为 持锁线程 补充创建 head 然后再自旋入队 1. cas tail() 成功了 2. pre【head】.next = node
        // 其实想表达的就是：已经有head.next节点了 其他线程再来这时 需要返回 true

        // 条件2.2 前置条件 h.next 不是空  s.thread != Thread.currentThread()
        // 条件成立：说明当前线程 就不是h.next 节点对应的线程  返回true
        // 条件不成立：说明当前线程 就是h.next节点对应的线程 需要返回false 回头线程会去竞争锁了

        return h != t && ((s = h.next) == null || s.thread != Thread.currentThread());
    }

    @Override
    public void unlock() {
        release(1);
    }


    private void release(int arg) {
        // 说明线程已经完全释放锁成功了
        if (tryRelease(arg)) {
            Node head = this.head;
            //
            if (head.next != null) {
                // 唤醒head.next节点
                unparkSuccessor(head);
            }
        }
    }


    private void unparkSuccessor(Node node) {
        Node s = node.next;
        if (s != null && s.thread != null) {
            LockSupport.unpark(s.thread);
        }
    }

    /**
     * 完全释放锁成功 返回true
     * 否则 说明当前 state > 0 返回false
     *
     * @param arg
     * @return
     */
    private boolean tryRelease(int arg) {
        int c = getState() - arg;

        if (getExclusiveOwnerThread() != Thread.currentThread()) {
            throw new RuntimeException("fuck you! must getLock");
        }

        // 如果执行这里 不存在并发 只有一个exclusiveOwnerThread 会来到这里

        // 当前线程释放锁
        if (c == 0) {
            this.exclusiveOwnerThread = null;
            this.state = c;
            return true;
        }

        this.state = c;
        return false;
    }

    private static final Unsafe unsafe;
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);

            stateOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("tail"));

        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    protected final boolean compareAndSetState(int expect, int update) {
        // See below for intrinsics setup to support this
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }
}