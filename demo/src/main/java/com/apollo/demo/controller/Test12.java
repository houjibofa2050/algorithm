package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 18:04
 * @email: fuguowen@fantaike.ai
 */
public class Test12 {
    public static void main(String[] args) {

        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(6);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        ListNode listNode = middleNode(listNode1);
        Test01.printList(listNode);


    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
