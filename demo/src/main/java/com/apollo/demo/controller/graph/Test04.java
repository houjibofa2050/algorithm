package com.apollo.demo.controller.graph;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-27 13:56
 * @email: fuguowen@fantaike.ai
 */
public class Test04 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        int allSum=1<<nums.length;
        for(int i=0;i<allSum;i++){
            List<Integer> arrayList=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    arrayList.add(nums[j]);
                }
            }
            set.add(new ArrayList<>(arrayList));
        }
        List<List<Integer>> list=new ArrayList<>(set);
        return list;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
