package com.apollo.demo.controller;

import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-23 15:38
 * @email: fuguowen@fantaike.ai
 */
public class Test15 {
    public static void main(String[] args) {
        String str="()";
        boolean valid = isValid(str);
        System.out.println(valid);

    }

    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        char c = s.charAt(0);
        boolean b = rightParenthesis(c);
        if(b){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        stack.push(c);

        for(int i=1;i<s.length();i++){
            char c1 = s.charAt(i);
            if(leftParenthesis(c1)){
                stack.push(c1);
            }
            if(!stack.isEmpty() && rightParenthesis(c1)){
                Character peek = stack.peek();
                boolean match = match(peek, c1);
                if(!match){
                    return false;
                }else{
                    stack.pop();
                }

            }else if(stack.isEmpty() && rightParenthesis(c1)){
                return false;
            }

        }
        if(stack.isEmpty()){
            return true;
        }

        return false;
    }

    public static boolean rightParenthesis(char c){
        if(c==')' || c=='}' || c== ']'){
            return true;
        }
        return false;
    }

    public static boolean leftParenthesis(char c){
        if(c=='(' || c=='{' || c== '['){
            return true;
        }
        return false;
    }

    public static boolean match(char c1,char c2){
        if((c1=='{' && c2=='}') || (c1=='(' && c2==')') || (c1=='[' && c2==']') ){
            return true;
        }

        return false;
    }
}
