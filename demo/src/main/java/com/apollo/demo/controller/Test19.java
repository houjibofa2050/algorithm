package com.apollo.demo.controller;

import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-23 17:55
 * @email: fuguowen@fantaike.ai
 */
public class Test19 {
    public static void main(String[] args) {
        String[] ops={"5","2","C","D","+"};
        int i = calPoints(ops);
        System.out.println(i);
    }

    public static int calPoints(String[] ops) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("+")){
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                stack.push(pop);
                stack.push(pop+peek);
            }else if(ops[i].equals("D")){
                stack.push(2*stack.peek());
            }else if(ops[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        while(!stack.isEmpty()){
            Integer num=stack.pop();
            ans+=num;
        }
        return ans;
    }


}
