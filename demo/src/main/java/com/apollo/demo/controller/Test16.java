package com.apollo.demo.controller;

import java.rmi.Remote;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-23 16:30
 * @email: fuguowen@fantaike.ai
 */
public class Test16 {
    public static void main(String[] args) {
        String str="abbaca";
        String s = removeDuplicates(str);
        System.out.println(s);
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        stack.push(S.charAt(0));
        for(int i=1;i< S.length();i++){
            char c = S.charAt(i);
            if(!stack.isEmpty()){
                Character peek = stack.peek();
                if(peek !=c){
                    stack.push(c);

                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }

        String stackStr = getStackStr(stack);
        return stackStr;
    }

    public static String  getStackStr(Stack stack){
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            Object peek = stack.peek();
            sb.append(peek);
            stack.pop();

        }
        return sb.reverse().toString();
    }

}
