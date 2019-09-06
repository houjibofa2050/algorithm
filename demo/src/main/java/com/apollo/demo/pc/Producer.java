package com.apollo.demo.pc;



/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-22 16:52
 * @email: fuguowen@fantaike.ai
 */
public class Producer {
    private Queue queue;
    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void produce(Long data) throws InterruptedException {
        while (!queue.add(data)) {
            Thread.sleep(100);
        }
    }
}
