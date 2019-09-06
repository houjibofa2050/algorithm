package com.apollo.demo.controller.array;

import lombok.val;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-04 16:57
 * @email: fuguowen@fantaike.ai
 */
public class Test07 {
    public static void main(String[] args) {
        int[] nums={5,2,6,1};
        List<Integer> list = countSmaller(nums);
        System.out.println(list);

    }
    public static class BSTNode{
        int val;
        //记录左子树中节点的个数
        int count;
        BSTNode left;
        BSTNode right;

        public BSTNode(int val) {
            this.val = val;
        }
    }


    public static List<Integer> countSmaller(int[] nums) {
        if(nums==null|| nums.length==0){
            return new ArrayList<>();
        }
        List<BSTNode> list=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            list.add(new BSTNode(nums[i]));
        }
        Map<Integer,Integer> map=new HashMap<>(16);
        int[] arr=new int[nums.length];
        map.put(list.get(0).val,0);
        for(int i=1;i<list.size();i++){
            int[] smallCount=new int[1];
            insertNode(list.get(0),list.get(i),smallCount);
            arr[i]=smallCount[0];
        }
        List<Integer> listNum=new ArrayList<>();
       for(int i=nums.length-1;i>=0;i--){
           listNum.add(arr[i]);
       }
        return listNum;
    }
    public static void insertNode(BSTNode root,BSTNode insertNode,int[] smallCount){
        if(root.val<insertNode.val){
            smallCount[0]+=(root.count+1);
            if(root.right!=null){
                insertNode(root.right,insertNode, smallCount);
            }else{
                root.right=insertNode;
            }
        }else{
            root.count++;
            if(root.left!=null){
                insertNode(root.left,insertNode,smallCount);
            }else{
                root.left=insertNode;
            }
        }
    }
}
