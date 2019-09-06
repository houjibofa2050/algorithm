package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 16:25
 * @email: fuguowen@fantaike.ai
 */
public class Test07 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(1);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
//        ListNode listNode = reverseListNode(listNode1);
//        Test01.printList(listNode);
        boolean palindrome = isPalindrome(listNode1);
        System.out.println(palindrome);

    }


    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }

        //1.找到链表的中间节点
       ListNode fast=head.next;
       ListNode slow=head;
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
       }
       //2.翻转后半段链表
        System.out.println(slow.next.val);
        ListNode listNode = reverseListNode(slow.next);
        System.out.println(listNode.val);
       while(listNode!=null && head!=null){
           if(head.val !=listNode.val){
               return false;
           }
           head=head.next;
           listNode=listNode.next;
       }
        return true;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static  ListNode reverseListNode(ListNode head){
        ListNode cur=head;
        ListNode reverse=null;

        while(cur!=null){
            ListNode second=cur.next;
            cur.next=reverse;
            reverse=cur;
            cur=second;
        }
        return reverse;
    }
}
