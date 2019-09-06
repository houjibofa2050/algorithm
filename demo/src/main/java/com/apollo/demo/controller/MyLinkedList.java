package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-22 17:39
 * @email: fuguowen@fantaike.ai
 */
class MyLinkedList {

    /**
     * 包含头结点的链表
     */
    ListNode head=null;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head=new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int num = -1;
        ListNode cur = head;
        while (cur!= null && cur.next!=null && (num<index)) {
            num++;
            cur = cur.next;
        }
        if(index==num && cur!=null){
            return cur.val;
        }
        return -1;
    }

    /**
     * 头插法
     */
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node=new ListNode(val);
        node.next=head.next;
        head.next=node;

    }

    /**
     * 尾插法
     */
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        cur.next = node;
        cur=node;
    }

    /**
     * 获得新增的前一个节点
     */
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i = 0;
        ListNode cur = head;
        while (cur.next != null && i<index) {
            i++;
            cur=cur.next;
        }

        if (i == index) {
            ListNode node=new ListNode(val);
            node.next=cur.next;
            cur.next=node;
        }
    }

    /**
     * 获得删除的前一个节点
     */
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        //前一个节点
        ListNode cur = head;
        while (cur!= null && cur.next!=null && i<index) {
            i++;
            cur=cur.next;
        }
        if (i == index && cur != null && cur.next != null) {
            cur.next = cur.next.next;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */