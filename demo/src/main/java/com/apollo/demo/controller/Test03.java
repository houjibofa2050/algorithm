package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 13:36
 * @email: fuguowen@fantaike.ai
 */
public class Test03 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(3);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(0);
        ListNode listNode4=new ListNode(-4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode2;
        boolean b = hasCycle(listNode1);
        System.out.println(b);

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
