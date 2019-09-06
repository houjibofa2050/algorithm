package com.apollo.demo.controller.array;

import com.apollo.demo.controller.TreeNode;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-05 09:19
 * @email: fuguowen@fantaike.ai
 */
public class Test08 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(3);
        TreeNode treeNode2=new TreeNode(5);
        TreeNode treeNode3=new TreeNode(1);
        TreeNode treeNode4=new TreeNode(6);
        TreeNode treeNode5=new TreeNode(2);
        TreeNode treeNode6=new TreeNode(0);
        TreeNode treeNode7=new TreeNode(8);
        TreeNode treeNode8=new TreeNode(7);
        TreeNode treeNode9=new TreeNode(4);



        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.right=treeNode6;
        treeNode3.left=treeNode7;
        treeNode5.left=treeNode8;
        treeNode5.right=treeNode9;

        TreeNode treeNode = lowestCommonAncestor(treeNode1, treeNode2, treeNode9);
        System.out.println(treeNode);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int[] flag=new int[1];
        LinkedList<TreeNode> pathList=new LinkedList<>();
        LinkedList<LinkedList<TreeNode>> resultList=new LinkedList<>();

        findParentNode(root,p,pathList,resultList,flag);
        pathList.clear();
        flag[0]=0;
        findParentNode(root,q,pathList,resultList,flag);
        int num;
        if(resultList.get(0).size()<resultList.get(1).size()){
            num=resultList.get(0).size();
        }else{
            num=resultList.get(1).size();
        }
        LinkedList<TreeNode> qResultList=resultList.get(1);
        LinkedList<TreeNode> pResultList=resultList.get(0);
        TreeNode parentNode=null;
        for(int i=0;i<num;i++){
            if(pResultList.get(i)==qResultList.get(i)){
                parentNode=pResultList.get(i);
            }else{
                break;
            }
        }

        return parentNode;
    }

    public static void findParentNode(TreeNode root, TreeNode p, LinkedList<TreeNode> pathList,
                                      LinkedList<LinkedList<TreeNode>> resultList, int[] flag){

        if(root==null|| flag[0]==1){
            return ;
        }
        pathList.addLast(root);
        if(root.val==p.val){
            resultList.add(new LinkedList<>(pathList));
            flag[0]=1;
        }

        findParentNode(root.left,p,pathList,resultList,flag);
        findParentNode(root.right,p,pathList,resultList,flag);
        pathList.removeLast();
    }
}
