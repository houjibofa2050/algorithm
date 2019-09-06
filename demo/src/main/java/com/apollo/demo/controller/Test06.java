package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 14:50
 * @email: fuguowen@fantaike.ai
 */
public class Test06 {
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
        if(head==null){
            return head;
        }
        // 1.找到头结点不为要删除的元素
        while(head!=null && head.val==val){
            head=head.next;
        }
        //2.找到要删除的元素跳过
        ListNode cur=head;
        if(cur==null){
            return cur;
        }
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }
}
