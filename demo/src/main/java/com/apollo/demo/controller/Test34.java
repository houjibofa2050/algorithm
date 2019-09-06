package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-12 09:39
 * @email: fuguowen@fantaike.ai
 */
public class Test34 {
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
        inorderTraversal(root,list);
        return list;
    }

    public static void inorderTraversal(TreeNode root,List<Integer> list) {

        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, list);
            }

        }

    }
}
