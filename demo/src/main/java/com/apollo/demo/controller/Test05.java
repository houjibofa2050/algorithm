package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 14:50
 * @email: fuguowen@fantaike.ai
 */
public class Test05 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(6);
        ListNode listNode4=new ListNode(3);
        ListNode listNode5=new ListNode(4);
        ListNode listNode6=new ListNode(5);
        ListNode listNode7=new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        ListNode listNode = removeElements(listNode1, 6);
       Test01.printList(listNode);


    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode headA=head;
        ListNode cur = new ListNode(-1);
        ListNode pre = cur;
        while (headA != null) {
            if (headA.val == val) {
                cur.next = headA.next;
                headA = headA.next;
            } else {
                cur.next = headA;
                headA = headA.next;
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
