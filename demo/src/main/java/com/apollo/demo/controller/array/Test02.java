package com.apollo.demo.controller.array;

import javax.swing.text.html.HTML;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-09-02 10:05
 * @email: fuguowen@fantaike.ai
 */
public class Test02 {
    public static void main(String[] args) {
        int[] A={-1,2,5,20,90,100,207,800};
        int[] B={2,200};
        for (int num : B) {
//            boolean flag = binarySerach(A, num);
            boolean flag = binarySerachRecursive(A, num,0,A.length-1);
            System.out.println(flag);
        }
    }

    /**
     * 循环二分查找
     * @param array
     * @param target
     * @return
     */
    public static boolean binarySerach(int[] array,int target){
        int begin=0;
        int end=array.length-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(array[mid]==target){
                return true;
            }else if(array[mid]<target){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

    public static boolean binarySerachRecursive(int[] array,int target,int  left,int right){

        if(left<=right){
            int mid=left+(right-left)/2;
            if(array[mid]==target){
                return true;
            }else if(array[mid]<target){
                return binarySerachRecursive(array,target,mid+1,right);
            }else{
                return binarySerachRecursive(array, target,left,mid-1);
            }
        }
        return false;
    }


}
