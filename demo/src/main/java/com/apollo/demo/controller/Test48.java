package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-22 09:22
 * @email: fuguowen@fantaike.ai
 */
public class Test48 {
    public static void main(String[] args) throws Exception {
        Thread.sleep(30000);
        while(true){
            loadData();
        }

    }
    public static void loadData() throws  Exception{
        byte[] data=null;
        for(int i=0;i<50;i++){
            data=new byte[100*1024];
        }
        data=null;
        Thread.sleep(1000);
    }
}
