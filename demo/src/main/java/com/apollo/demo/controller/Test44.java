package com.apollo.demo.controller;

import sun.rmi.transport.tcp.TCPTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-20 16:00
 * @email: fuguowen@fantaike.ai
 */
public class Test44 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = preorderTraversal(treeNode1);
        System.out.println(list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>(10);
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
//                System.out.print(treeNode.val+"  ");
                list.add(treeNode.val);
                treeNode=treeNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                treeNode=pop.right;
            }
        }
        return list;

    }
}
