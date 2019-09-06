package com.apollo.demo.controller;

import org.apache.ibatis.annotations.Delete;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 17:28
 * @email: fuguowen@fantaike.ai
 */
public class Test08 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(1);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;

        deleteNode(listNode3);
        Test01.printList(listNode1);

    }


    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
