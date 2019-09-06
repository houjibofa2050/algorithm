package com.apollo.demo.controller;

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
public class Test45 {
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
        TreeNode treeNode = buildTree(preorder, 0, preorder.length-1,inorder,0,inorder.length-1,map);
        return treeNode;
    }

    public static TreeNode buildTree(int[] preorder,int pi,int pj,int[] inorder,int ni,int nj,Map<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        Integer index = map.get(preorder[pi]);
        TreeNode root=new TreeNode(preorder[pi]);
        root.left=buildTree(preorder,pi+1,index-ni+pi,inorder,ni,index-1,map);
        root.right=buildTree(preorder,index-ni+pi+1,pj,inorder,index+1,nj,map);
        return root;
    }
}
