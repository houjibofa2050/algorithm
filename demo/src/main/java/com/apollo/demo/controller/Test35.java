package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-12 09:39
 * @email: fuguowen@fantaike.ai
 */
public class Test35 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = inorderTraversal(treeNode1);
        System.out.println(list);


    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode=treeNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                list.add(pop.val);
                treeNode=pop.right;
            }
        }
        return list;
    }

    public static void medOrderTraver(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode=treeNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.print(pop.val+"  ");
                treeNode=pop.right;
            }
        }
    }

}
