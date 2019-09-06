package com.apollo.demo.controller;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-11 08:36
 * @email: fuguowen@fantaike.ai
 */
public class Test33 {
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

        List<List<Integer>> lists = levelOrderBottom(treeNode1);
        System.out.println(lists);
    }
    
    
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list2=new ArrayList<>();
            for(int i=0;i<size;i++){

                TreeNode poll = queue.poll();
                list2.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            list.add(0,list2);
            System.out.println();
           
        }
        return list;
    }

}
