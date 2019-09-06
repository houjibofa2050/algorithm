package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-08 10:19
 * @email: fuguowen@fantaike.ai
 */
public class Test23 {

    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(2);
        boolean symmetric = isSymmetric(p);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return isSymmetric(root.left,root.right);
        }
    }

    public static boolean isSymmetric(TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else {
            if (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                } else {
                    return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
                }
            }else{
                return false;
            }
        }
    }
}
