package com.apollo.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-20 14:05
 * @email: fuguowen@fantaike.ai
 */
public class Test40 {
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
        List<String> paths=new ArrayList<>(10);
        printPath(root,"",paths);
//        System.out.println(paths);
        return paths;
    }
    public static void printPath(TreeNode root,String path,List<String> paths){
        if (root == null) {
            return;
        }
        path+=root.val;
        //叶子节点,加入路径
        if (root.left == null && root.right == null) {
            paths.add(path);
            //非叶子节点
        }else{
            path+="->";
            printPath(root.left,path,paths);
            printPath(root.right,path,paths);
        }
    }
}
