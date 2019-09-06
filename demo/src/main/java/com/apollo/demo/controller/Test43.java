package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-20 15:13
 * @email: fuguowen@fantaike.ai
 */
public class Test43 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(3);
        TreeNode treeNode2=new TreeNode(9);
        TreeNode treeNode3=new TreeNode(20);
        TreeNode treeNode5=new TreeNode(15);
        TreeNode treeNode6=new TreeNode(7);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode3.left=treeNode5;
        treeNode3.right=treeNode6;
        List<List<Integer>> lists = levelOrder(treeNode1);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root == null){
            return list;
        }
        levelOrderMethod(root,list,0);
//        System.out.println(list);
        return list;

    }

    public static void levelOrderMethod(TreeNode root,List<List<Integer>> list,int level) {
        if(level==list.size()){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if(root.left!=null){
            levelOrderMethod(root.left,list,level+1);
        }
        if(root.right!=null){
            levelOrderMethod(root.right,list,level+1);
        }

    }
}
