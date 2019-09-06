package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-21 11:34
 * @email: fuguowen@fantaike.ai
 */
public class Test47 {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] nums,int left,int right) {
        if(left>right){
            return null;
        }
        int middle=(left+right)/2;
        TreeNode treeNode=new TreeNode(nums[middle]);
        treeNode.left=sortedArrayToBST(nums,left,middle-1);
        treeNode.right=sortedArrayToBST(nums,middle+1,right);
        return treeNode;
    }
}
