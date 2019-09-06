package com.apollo.demo.pc;


/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-22 16:53
 * @email: fuguowen@fantaike.ai
 */
public class Consumer {
    private Queue queue;
    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public void comsume() throws InterruptedException {
        while (true) {
            Long data = queue.poll();
            if (data == null) {
                Thread.sleep(100);
            } else {
                // TODO:... 消费数据的业务逻辑...
            }
        }
    }
}
