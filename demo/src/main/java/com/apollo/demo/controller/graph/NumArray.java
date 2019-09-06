package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-01 07:13
 * @email: fuguowen@fantaike.ai
 */
public class NumArray {
    int[] value;
    public NumArray(int[] nums) {
        value=nums;
    }

    public void update(int i, int val) {
        value[i]=val;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=value[k];
        }
        return sum;
    }
}
