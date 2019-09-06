package com.apollo.demo.controller.array;

import com.apollo.demo.controller.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-04 09:43
 * @email: fuguowen@fantaike.ai
 */
public class Test06 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(5);
        TreeNode treeNode2=new TreeNode(4);
        TreeNode treeNode3=new TreeNode(8);
        TreeNode treeNode4=new TreeNode(11);
        TreeNode treeNode5=new TreeNode(13);
        TreeNode treeNode6=new TreeNode(4);
        TreeNode treeNode7=new TreeNode(7);
        TreeNode treeNode8=new TreeNode(2);
        TreeNode treeNode9=new TreeNode(5);
        TreeNode treeNode10=new TreeNode(1);



        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.left=treeNode5;
        treeNode3.right=treeNode6;
        treeNode4.left=treeNode7;
        treeNode4.right=treeNode8;
        treeNode6.left=treeNode9;
        treeNode6.right=treeNode10;
        List<List<Integer>> lists = pathSum(treeNode1, 22);
        System.out.println(lists);


    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        LinkedList<Integer> linkedList=new LinkedList<>();

        int[] pathSum=new int[1];
        preOrder(root,list,linkedList,pathSum,sum);
        return list;
    }

    public static void preOrder(TreeNode root,List<List<Integer>> list,
                                LinkedList<Integer> pathList,
                         int[] pathNum,int sum){
        if (root == null) {
            return;
        }
        pathNum[0] = pathNum[0] + root.val;
        pathList.addLast(root.val);

        if (pathNum[0] == sum && root.left==null &&root.right==null) {
            list.add(new ArrayList<>(pathList));
        }
        preOrder(root.left, list, pathList, pathNum, sum);
        preOrder(root.right, list, pathList, pathNum, sum);

        pathNum[0] = pathNum[0] - root.val;
        pathList.removeLast();
    }
}
