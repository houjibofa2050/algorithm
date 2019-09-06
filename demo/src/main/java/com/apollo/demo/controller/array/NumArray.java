package com.apollo.demo.controller.array;

import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-01 07:29
 * @email: fuguowen@fantaike.ai
 */
public class NumArray {
    int[] value;
    int rightEnd;
    SegmentTree segmentTree=new SegmentTree();

    public NumArray(int[] nums) {
        if(nums==null|| nums.length==0){
            return ;
        }
        value=new int[nums.length*4];
        segmentTree.buildSegmentTree(value,nums,0,0,nums.length-1);
        rightEnd=nums.length-1;
    }

    public void update(int i, int val) {
        segmentTree.updateSegmentTree(value,0,0, rightEnd,i,val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.sumSegmentTree(value,0,0,rightEnd,i,j);
    }
}
