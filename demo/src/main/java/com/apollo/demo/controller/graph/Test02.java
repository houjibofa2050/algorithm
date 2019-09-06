package com.apollo.demo.controller.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-27 10:03
 * @email: fuguowen@fantaike.ai
 */
public class Test02 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        LinkedList<Integer> linkedList=new LinkedList<>();
        list.add(new ArrayList<>());
        int n=nums.length;
        subsetsList(0,list,linkedList,n,nums);
        return list;
    }

    /**
     * 求集合的子集
     * @param i
     * @param list
     * @param linkedList
     * @param n
     * @param nums
     */
    public static void subsetsList(int i, List<List<Integer>> list, LinkedList<Integer> linkedList,int n,int[] nums) {
        if(i==n){
            return ;
        }else{
            linkedList.addLast(nums[i]);
            list.add(new ArrayList<>(linkedList));
            subsetsList(i+1,list,linkedList,n,nums);
            linkedList.removeLast();
            subsetsList(i+1,list,linkedList,n,nums);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);

    }

}
