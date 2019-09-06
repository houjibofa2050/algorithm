package com.apollo.demo.controller.array;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-01 07:43
 * @email: fuguowen@fantaike.ai
 */
public class Test01 {
    public static void main(String[] args) {
        int[] nums=new int[6];
        int[] value=new int[24];
        for(int i=0;i<nums.length;i++){
            nums[i]=i;
        }

        SegmentTree segmentTree=new SegmentTree();
        segmentTree.buildSegmentTree(value,nums,0,0,nums.length-1);
        System.out.println(segmentTree);
        segmentTree.printSegmentTree(value,0,0,nums.length-1,0);
        int i = segmentTree.sumSegmentTree(value, 0, 0, nums.length - 1, 2, 4);
        System.out.println(i);

        segmentTree.updateSegmentTree(value,0,0,nums.length-1,1,5);
        System.out.println(segmentTree);

    }
}
