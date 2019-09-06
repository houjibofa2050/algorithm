package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 18:04
 * @email: fuguowen@fantaike.ai
 */
public class Test13 {
    public static void main(String[] args) {

        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);
        ListNode listNode6=new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;

        listNode4.next=listNode5;
        listNode5.next=listNode6;

        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        Test01.printList(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int temp = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + temp;
            int value = num % 10;
            ListNode node = new ListNode(value);
            temp = num / 10;
            cur.next = node;
            cur = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(temp!=0){
            cur.next=new ListNode(temp);
        }

        return head.next;

    }
}
