package com.apollo.demo.controller.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-27 16:12
 * @email: fuguowen@fantaike.ai
 */
public class Test06 {
    public static void main(String[] args) {
        int n=3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        String item="";
        generateParenthesisList(n,list,item,0);
        return list;
    }

    public static void generateParenthesisList(int n,List<String> list,String item,int i) {

        if(item.length()==2*n && isFalg2(item,n)){
            list.add(item);
        }else{
            if(isFalg3(item,n)){
                generateParenthesisList(n,list,item+"(",i+1);
            }
            if(isFalg(item)){
                generateParenthesisList(n,list,item+")",i+1);
            }

        }

    }


    public static boolean isFalg(String item){
        int left=0;
        int right=0;
        char[] chars = item.toCharArray();
        for (char c : chars) {
            if(c=='('){
                left++;
            }
            if(c==')'){
                right++;
            }
        }

        if(left<=right){
            return false;
        }
        return true;
    }


    public static boolean isFalg2(String item,int n){
        int left=0;
        int right=0;
        char[] chars = item.toCharArray();
        for (char c : chars) {
            if(c=='('){
                left++;
            }
            if(c==')'){
                right++;
            }
        }

        if(left==right&& left==n){
            return true;
        }
        return false;
    }

    public static boolean isFalg3(String item,int n){
        int left=0;
        int right=0;
        char[] chars = item.toCharArray();
        for (char c : chars) {
            if(c=='('){
                left++;
            }
        }

        if(left>n-1){
            return false;
        }
        return true;
    }
}
