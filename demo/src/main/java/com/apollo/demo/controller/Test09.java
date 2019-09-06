package com.apollo.demo.controller;

import org.apache.ibatis.io.ResolverUtil;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 18:04
 * @email: fuguowen@fantaike.ai
 */
public class Test09 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        Test01.printList(linkedList.head.next);
        System.out.println("=======================");
        System.out.println(linkedList.get(1));//返回2
        System.out.println("=======================");
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println("=======================");
        Test01.printList(linkedList.head.next);
        System.out.println("=======================");
        System.out.println(linkedList.get(1));//返回3
//        System.out.println(linkedList.head);
        Test01.printList(linkedList.head.next);


    }
}
