package com.apollo.demo.controller.graph;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-27 15:19
 * @email: fuguowen@fantaike.ai
 */
public class Test05 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set=new HashSet<>();
        LinkedList<Integer> linkedList=new LinkedList<>();
        int n=candidates.length;
        subsetsList(0,set,linkedList,n,candidates,0,target);
        List<List<Integer>> list=new ArrayList<>(set);
        return list;
    }

    public static void subsetsList(int i, Set<List<Integer>> list, LinkedList<Integer> linkedList, int n, int[] nums,int sum,int target) {
        if(i==n|| sum>target){
            return ;
        }else{
            sum+=nums[i];
            linkedList.addLast(nums[i]);
            if(sum==target){
                list.add(new ArrayList<>(linkedList));
            }

            subsetsList(i+1,list,linkedList,n,nums,sum,target);
            linkedList.removeLast();
            sum-=nums[i];
            subsetsList(i+1,list,linkedList,n,nums,sum,target);
        }
    }

    public static void main(String[] args) {

        int[] candidates={10,1,2,7,6,1,5};
        int target=8;

        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
