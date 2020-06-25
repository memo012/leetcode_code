package com.adminsys.生产者消费者.synchronize;

import java.util.LinkedList;
import java.util.List;
/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-30 12-32
 **/
public class MessageStorage {
    private int maxSize;
    private List<String> messages;

    public MessageStorage(int maxSize) {
        this.maxSize = maxSize;
        messages = new LinkedList<String>();
    }

    public void add(String mess) {
        synchronized (this) {
            while (maxSize == messages.size()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            messages.add(mess);
            notifyAll();
        }
    }

    public String get() {
        String message = null;
        synchronized (this) {
            while (messages.size() == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            message = ((LinkedList<String>) messages).poll();
            notifyAll();
        }
        return message;
    }
}