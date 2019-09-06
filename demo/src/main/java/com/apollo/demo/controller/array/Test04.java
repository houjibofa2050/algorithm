package com.apollo.demo.controller.array;

import java.util.Arrays;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-03 16:33
 * @email: fuguowen@fantaike.ai
 */
public class Test04 {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=6;
        int[] arr = searchRange(nums, target);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] arr=new int[2];
        int left = leftBound(nums, target);
        arr[0]=left;

        int right = rightBound(nums, target);
        arr[1]=right;

        return arr;
    }

    public static int leftBound(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<target){
                    return mid;
                }
                end=mid-1;
            }else if(nums[mid]<target){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static int rightBound(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]>target){
                    return mid;
                }
                begin=mid+1;
            }else if(nums[mid]<target){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
