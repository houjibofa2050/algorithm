package com.apollo.demo.controller;

import com.apollo.demo.controller.TreeNode;

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
public class Test37 {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        List<Double> doubles = averageOfLevels(treeNode);
        System.out.println(doubles);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> lists = levelOrderBottom(root);
        System.out.println(lists);
        List<Double> doubleList=new ArrayList<>();
        for (List<Integer> list : lists) {
            double v = averageList(list);
            doubleList.add(v);
        }


        return doubleList;
    }
    public static double averageList(List<Integer> list){
        double sum=0;

        for (Integer num : list) {
            sum+=num;
        }
        return sum/list.size();
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
            list.add(list2);
        }


        return list;
    }
}
