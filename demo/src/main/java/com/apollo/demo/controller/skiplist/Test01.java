package com.apollo.demo.controller.skiplist;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-28 17:57
 * @email: fuguowen@fantaike.ai
 */
public class Test01 {
    public static void main(String[] args) {
            // TODO Auto-generated method stub
            SkipList<String> list=new SkipList<String>();
            System.out.println(list);
            list.put(2, "yan");
            list.put(1, "co");
            list.put(3, "feng");
            list.put(1, "cao");//测试同一个key值
            list.put(4, "曹");
            list.put(6, "丰");
            list.put(5, "艳");
            System.out.println(list);
            System.out.println(list.size());
    }
}
