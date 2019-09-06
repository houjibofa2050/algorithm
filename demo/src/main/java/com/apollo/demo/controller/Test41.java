package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-20 14:05
 * @email: fuguowen@fantaike.ai
 */
public class Test41 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode5=new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode5;
        List<String> list = binaryTreePaths(treeNode1);
        System.out.println(list);

    }
    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<TreeNode> nodeList=new LinkedList<>();
        LinkedList<String> pathList=new LinkedList<>();
        List<String> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        nodeList.add(root);
        pathList.add(root.val+"");
        while(!nodeList.isEmpty()){
            TreeNode treeNode = nodeList.pollLast();
            String path= pathList.pollLast();
            if (treeNode.left == null && treeNode.right == null) {
                list.add(path);
            }
            if(treeNode.left!=null){
                nodeList.add(treeNode.left);
                pathList.add(path+"->"+treeNode.left.val);
            }

            if((treeNode.right!=null)){
                nodeList.add(treeNode.right);
                pathList.add(path+"->"+treeNode.right.val);
            }
        }


        return  list;
    }

}
