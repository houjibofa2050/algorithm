package com.apollo.demo.controller;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-12 13:17
 * @email: fuguowen@fantaike.ai
 */
public class Test36 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>(16);
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode treeNode = buildTree(preorder, 0, inorder.length, map, 0);
        return treeNode;
    }

    public static TreeNode buildTree(int[] preorder,int left,int right,Map<Integer,Integer> map,int pre_idx){
        if(pre_idx<preorder.length && left<right){
            int root_val = preorder[pre_idx];
            Integer index = map.get(root_val);
            TreeNode root=new TreeNode(root_val);
            root.left=buildTree(preorder,left,index-1,map,pre_idx+1);
            root.right=buildTree(preorder,index+1,right,map,pre_idx+1);
            return root;
        }
        return null;

    }
}
