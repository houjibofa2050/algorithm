package com.apollo.demo.controller;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-23 17:40
 * @email: fuguowen@fantaike.ai
 */
public class Test18 {
    public static void main(String[] args) {
        String S = "a##c";
        String T="#a#c";
        boolean b = backspaceCompare(S, T);
        System.out.println(b);
    }

    public static boolean backspaceCompare(String S, String T) {
        String realStrS = getRealStr(S);
        String realStrT = getRealStr(T);
        if(realStrS.equals(realStrT)){
            return true;
        }
        return false;
    }

    public static String getRealStr(String S){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c=='#' && !stack.isEmpty()){
                stack.pop();
            }else if(c !='#'){
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
