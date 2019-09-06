package com.apollo.demo.controller.array;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-03 16:08
 * @email: fuguowen@fantaike.ai
 */
public class Test03 {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=0;
        int num = searchInsert(nums, target);
        System.out.println(num);

    }

    public static int searchInsert(int[] nums, int target) {
        int begin=0;
        int end=nums.length-1;
        int index=-1;
        while(index==-1){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                if(mid==nums.length-1||nums[mid+1]>target){
                    index=mid+1;
                }
                begin=mid+1;
            }else{
                if( mid==0 || nums[mid-1]<target){
                    index=mid;
                }
                end=mid-1;
            }
        }
        return index;
    }
}
