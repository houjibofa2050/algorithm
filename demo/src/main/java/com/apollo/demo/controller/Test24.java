package com.apollo.demo.controller;

import sun.awt.SunHints;
import sun.reflect.generics.tree.Tree;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-08 10:19
 * @email: fuguowen@fantaike.ai
 */
public class Test24 {

    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(3);
        boolean symmetric = isSymmetric(p);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode p=root.left;
        TreeNode q=root.right;
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode one = queue.poll();
            TreeNode two= queue.poll();
            if(one==null && two ==null){
                continue;
            }
            if(one == null || two == null){
                return false;
            }
            if(one.val!=two.val){
                return false;
            }
            queue.add(one.left);
            queue.add(two.right);
            queue.add(one.right);
            queue.add(two.left);
        }
       return true;
    }


}
