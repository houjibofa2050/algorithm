package com.apollo.demo.controller;

import org.w3c.dom.ls.LSException;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-08 14:13
 * @email: fuguowen@fantaike.ai
 */
public class Test26 {
    public static int curNum=0;
    public static int maxNum=0;
    public static int pre=0;
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(1);
        p.right=new TreeNode(2);
        findMode(p);

    }

    public static int[] findMode(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return new int[]{};
        }
        pre=root.val;
        medOrder(root,list);
        int[] arr=new int[list.size()];
        int i=0;
        for (Integer num : list) {
            arr[i]=num;
            i++;
        }
        return arr;

    }
    public static void medOrder(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        TreeNode left = root.left;
        if(left!=null){
            medOrder(left,list);
        }
        if(pre==root.val){
            curNum++;
        }else{
            curNum=1;
        }
        if(curNum>maxNum){
            list.clear();
            maxNum=curNum;
            list.add(root.val);
            System.out.println("1: "+list);

        }else if(curNum==maxNum){
            list.add(root.val);
            System.out.println("2:"+list);
        }
        pre=root.val;

        TreeNode right = root.right;
        if(right!=null){
            medOrder(right,list);
        }

    }
}
