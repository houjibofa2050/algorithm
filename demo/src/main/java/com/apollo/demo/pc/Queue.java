package com.apollo.demo.pc;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-22 16:52
 * @email: fuguowen@fantaike.ai
 */
public class Queue {
    private Long[] data;
    private int size = 0, head = 0, tail = 0;
    public Queue(int size) {
        this.data = new Long[size];
        this.size = size;
    }

    public boolean add(Long element) {
        if ((tail + 1) % size == head) return false;
        data[tail] = element;
        tail = (tail + 1) % size;
        return true;
    }

    public Long poll() {
        if (head == tail){
            return null;
        }
        long ret = data[head];
        head = (head + 1) % size;
        return ret;
    }
}
