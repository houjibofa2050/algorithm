package com.apollo.demo.controller;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-10 21:25
 * @email: fuguowen@fantaike.ai
 */
public class Test32 {
    public static void main(String[] args) {

        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;

        treeNode3.right=treeNode6;

//        preOrderTraver(treeNode1);
//        medOrderTraver(treeNode1);
        postOrderTraver(treeNode1);



    }
    public static void preOrderTraver(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                System.out.print(treeNode.val+"  ");
                treeNode=treeNode.left;
            }

            if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                treeNode=pop.right;
            }
        }
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

    public static void postOrderTraver(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                stack2.push(0);
                treeNode=treeNode.left;
            }

            if(!stack.isEmpty()){
                Integer peek = stack2.peek();
                if(peek==0){
                    TreeNode peek1 = stack.peek();
                    treeNode=peek1.right;
                    stack2.pop();
                    stack2.push(1);
                }else{
                    TreeNode peek2=stack.pop();
                    stack2.pop();
                    System.out.print(peek2.val+" ");
                    treeNode=null;
                }
            }
        }
    }


}
