package com.apollo.demo.controller.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-27 13:29
 * @email: fuguowen@fantaike.ai
 */
public class Test03 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int allSum=1<<nums.length;
        for(int i=0;i<allSum;i++){
            List<Integer> arrayList=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    arrayList.add(nums[j]);
                }
            }
            list.add(new ArrayList<>(arrayList));
        }
        return list;
    }
}
