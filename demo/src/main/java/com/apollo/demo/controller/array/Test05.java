package com.apollo.demo.controller.array;

import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-03 17:10
 * @email: fuguowen@fantaike.ai
 */
public class Test05 {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=3;
        int search = search(arr, target);
        System.out.println(search);


    }
    public static int search(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){

                if(nums[begin]<=nums[mid]){
                    //begin-->mid-1 递增区间  mid+1-->end 旋转区间
                    //目标值在mid+1---end之间
                    begin=mid+1;
                }else if(nums[begin]>nums[mid]){
                    //mid+1-->end 是递增区间  begin--->mid-1 是旋转区间  隐藏 nums[begin]>nums[end]
                    if(nums[begin]<target){
                        //在begin-->mid-1 旋转区间中寻找
                        end=mid-1;
                    }else if(nums[begin]>target){
                        //在mid+1--->end 递增区间中寻找
                        begin=mid+1;
                    }else{
                        return begin;
                    }
                }
            }else if(nums[mid]>target){

                if(nums[mid]>nums[begin]){
                    //begin-->mid 递增区间  mid+1--->end 旋转区间
                    if(nums[begin]>target){
                        //在mid+1--->end 旋转区间寻找
                        begin=mid+1;
                    }else if(nums[begin]<target){
                        //在begin--->mid 递增区间中寻找
                        end=mid-1;
                    }else{
                        return begin;
                    }
                }else if(nums[mid]<nums[begin]){
                    //begin-->mid 旋转区间   mid+1--->end 是递增区间
                    //在旋转区间中寻找
                    end=mid-1;
                }else{
                    begin=mid+1;
                }
            }
        }
        return -1;

    }
}
