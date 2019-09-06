package com.apollo.demo.controller.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-26 17:40
 * @email: fuguowen@fantaike.ai
 */
public class Permute01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }
        int n=arrayList.size();
        permulteList(arrayList, list, 0,n);
        return list;
    }

    public static void permulteList(List<Integer> arrayList, List<List<Integer>> list, int first,int n) {
        if (first == n) {
            // 添加数组到排列中
            list.add(new ArrayList<>(arrayList));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(arrayList, first, i);
            permulteList(arrayList, list, first + 1,n);
            Collections.swap(arrayList, first, i);
        }
    }
    
}
