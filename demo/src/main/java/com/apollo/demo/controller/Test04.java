package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 14:27
 * @email: fuguowen@fantaike.ai
 */
public class Test04 {


    public static void main(String[] args) {

        ListNode listNode1=new ListNode(0);
        ListNode listNode2=new ListNode(9);
        ListNode listNode3=new ListNode(1);
        ListNode listNode4=new ListNode(2);
        ListNode listNode5=new ListNode(4);

        ListNode listNode6=new ListNode(3);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        listNode6.next=listNode4;

        ListNode intersectionNode = getIntersectionNode(listNode1, listNode6);
        System.out.println(intersectionNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            if (preB != null) {
                preB = preB.next;
            } else {
                preB = headA;
            }

            if (preA != null) {
                preA = preA.next;
            } else {
                preA = headB;
            }
        }
        return preA;
    }

}
