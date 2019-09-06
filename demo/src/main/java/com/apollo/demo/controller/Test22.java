package com.apollo.demo.controller;

import javax.transaction.TransactionRequiredException;
import java.time.chrono.IsoChronology;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-08 10:02
 * @email: fuguowen@fantaike.ai
 */
public class Test22 {
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(3);

        TreeNode q=new TreeNode(1);
//        q.left=new TreeNode(4);
        q.right=new TreeNode(3);

        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            if(p==null && q==null){
                return true;
            }else{
                return false;
            }
        }
    }
}
