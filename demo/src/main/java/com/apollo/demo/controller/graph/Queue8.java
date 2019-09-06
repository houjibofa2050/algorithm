package com.apollo.demo.controller.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-26 16:11
 * @email: fuguowen@fantaike.ai
 */
public class Queue8 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        int[] result=new int[n];

        queue8(0,list,result,n);
        return list;
    }
    public static void queue8(int row,List<List<String>> list,int[] result,int n){
        if(row==n){
            //添加图形到List
            addList(list,result);
        }else{
            //按照列填充
            for(int col=0;col<n;col++){
                Boolean valid = isValid(row, col, result);
                if(valid){
                    result[row]=col;
                    queue8(row+1,list,result,n);
                }
            }
        }
    }

    public static void addList(List<List<String>> list,int[] result){
        List<String> arrayList=new ArrayList<>();
        for(int i=0;i<result.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<result.length;j++){
                if(result[i]==j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            arrayList.add(sb.toString());
        }
        list.add(arrayList);

    }

    public static Boolean isValid(int row,int col,int[] result){
        for(int i=0;i<row;i++){
            //列已存在
            if(result[i]==col){
                return false;
            }
            //主对角线
            if(i-result[i]==row-col){
                return false;
            }
            //次对角线
            if(i+result[i]==row+col){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists);
    }


}
