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
 * @date: 2019-08-19 17:48
 * @email: fuguowen@fantaike.ai
 */
public class Test39 {

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        boolean balanced = isBalanced(treeNode);
        System.out.println(balanced);
    }



    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = getHight(root.left);
        int right = getHight(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 计算树的高度
     * @return
     */
    public static int getHight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getHight(root.left);
        int right=getHight(root.right);

        return Math.max(left,right)+1;
    }


}
