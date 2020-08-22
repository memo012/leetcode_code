package com.adminsys.猿辅导.队实现栈;


import java.util.LinkedList;

/**
 * @Author: qiang
 * @Description: 队实现栈
 * @Create: 2020-06-03 20-47
 **/

public class QueueStack {

    private LinkedList<Integer> queue1 = new LinkedList<>();
    private LinkedList<Integer> queue2 = new LinkedList<>();

    public void add(int element) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(element);
        } else if (!queue1.isEmpty()) {
            queue1.add(element);
        } else if (!queue2.isEmpty()) {
            queue2.add(element);
        }
    }

    public int poll() {
        int element;
        if (queue2.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.add(queue1.pop());
            }
            element = queue1.pop();
        }else {
            while (queue2.size() != 1) {
                queue1.add(queue2.pop());
            }
            element = queue2.pop();
        }
        return element;
    }

}
