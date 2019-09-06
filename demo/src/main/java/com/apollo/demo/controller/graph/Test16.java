package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-01 07:25
 * @email: fuguowen@fantaike.ai
 */
public class Test16 {
    public static void main(String[] args) {
        int[] num={1,3,5};
        NumArray numArray=new NumArray(num);
        int sum = numArray.sumRange(0, 2);
        System.out.println(sum);

    }
}
