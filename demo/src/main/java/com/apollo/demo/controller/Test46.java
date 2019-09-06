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
public class Test46 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder={9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);


    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>(16);
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode treeNode = buildTree(inorder, 0, inorder.length-1,postorder,0,postorder.length-1,map);
        return treeNode;
    }

    public static TreeNode buildTree(int[] inorder,int pi,int pj,int[] postorder,int ni,int nj,Map<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        Integer index = map.get(postorder[nj]);
        TreeNode root=new TreeNode(postorder[nj]);
        root.left=buildTree(inorder,pi,index-1,postorder,ni,ni+index-pi-1,map);
        root.right=buildTree(inorder,index+1,pj,postorder,ni+index-pi,nj-1,map);
        return root;
    }


}
