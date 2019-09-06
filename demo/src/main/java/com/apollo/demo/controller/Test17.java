package com.apollo.demo.controller;

import java.rmi.Remote;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-23 17:25
 * @email: fuguowen@fantaike.ai
 */
public class Test17 {
    public static void main(String[] args) {
        String s="(()())(())(()(()))";
        String s1 = removeOuterParentheses(s);
        System.out.println(s1);

    }

    public static String removeOuterParentheses(String S) {
        Stack<Character> stack=new Stack<>();
        int flag=0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '('){
                flag++;
                if(flag>1){
                    stack.push(c);
                }
            }else{
                flag--;
                if(flag>0){
                    stack.push(c);
                }
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
