package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-19 17:07
 * @email: fuguowen@fantaike.ai
 */
public class Test38 {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        List<Double> doubles = averageOfLevels(treeNode);
        System.out.println(doubles);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = levelOrderBottom(root);
        return lists;
    }

    public static List<Double> levelOrderBottom(TreeNode root) {
        List<Double> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum=0.0;
            List<Integer> list2=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                sum+=poll.val;
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}
