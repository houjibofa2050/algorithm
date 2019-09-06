package com.apollo.demo.controller;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-24 10:47
 * @email: fuguowen@fantaike.ai
 */
public class Test20 {

    public static void main(String[] args) {
//        int[] nums1 ={4,1,2};
//        int[] nums2 ={1,3,4,2};
        int[] nums1 ={1,3,5,2,4};
        int[] nums2 ={6,5,4,3,2,1,7};
        int[] arr = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>(16);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums2.length; i++) {

                while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                    map.put(stack.peek(), nums2[i]);
                    stack.pop();

                }
                stack.push(nums2[i]);
            }

            int[] arr = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                Integer num = map.get(nums1[i]);
                if (num == null) {
                    arr[i] = -1;
                } else {
                    arr[i] = num;
                }
            }

            return arr;
    }
}
