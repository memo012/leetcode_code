package com.adminsys.redis.跳跃表;

/**
 * @Author: qiang
 * @Description: 跳跃表实现
 * @Create: 2020-05-06 16-01
 **/

/**
 * 思路：
 * 首先定义一个数据结构 包括节点值 下一个节点 右一个节点
 */
public class Skiplist {
    class Node {
        int value;
        Node right;
        Node down;

        Node(int value, Node right, Node down) {
            this.value = value;
            this.right = right;
            this.down = down;
        }
    }

    private int level = 0;
    private Node head = null;

    /**
     * 查询
     *
     * @param target 目标值
     * @return
     */
    public boolean search(int target) {
        Node currentNode = head;
        while (currentNode != null) {
            while (currentNode.right != null && currentNode.right.value < target) {
                currentNode = currentNode.right;
            }
            if (currentNode.right != null && currentNode.right.value == target) {
                return true;
            }
            currentNode = currentNode.down;
        }
        return false;
    }

    /**
     * 添加
     */
    public void add(int num) {
        // 可以将num值最高增加到的层数
        int rlevel = 1;
        while (rlevel <= level && throwCoin()) {
            rlevel++;
        }
        if (rlevel > level) {
            level = rlevel;
            head = new Node(num, null, head);
        }

        Node current = head, last = null;
        for (int i = level; i >= 1; i--) {
            while (current.right != null && current.right.value < num) {
                current = current.right;
            }
            if (i <= rlevel) {
                current.right = new Node(num, current.right, null);
                if (last != null) {
                    last.down = current.right;
                }
                last = current.right;
            }
            current = current.down;
        }
    }

    /**
     * 删除
     *
     * @param num
     * @return
     */
    public boolean erase(int num) {
        Node current = head;
        boolean seen = false;
        for (int i = level; i >= 1; i--) {
            while (current.right != null && current.right.value < num) {
                current = current.right;
            }
            if (current.right != null && current.right.value == num) {
                seen = true;
                Node tmp = current.right;
                current.right = tmp.right;
            }
            current = current.down;
        }
        return seen;
    }

    public boolean throwCoin() {
        // 抛硬币 50% 概率
        return Math.random() < 0.5f;
    }

    public static void main(String[] args) {
        Skiplist s = new Skiplist();
//        s.add(5);
//        s.add(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(s.throwCoin());
        }
    }

}

