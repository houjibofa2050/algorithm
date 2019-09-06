package com.apollo.demo.controller;

import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-07-24 11:42
 * @email: fuguowen@fantaike.ai
 */
public class MinStack {

    Integer minValue;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minValue=Integer.MAX_VALUE;
        stack=new Stack<>();
    }

    public void push(int x) {
        if (x <= minValue) {
            //把上一个值 入栈
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer peek = stack.peek();
        if(peek.compareTo(minValue)==0){
            stack.pop();
            minValue=stack.peek();
            stack.pop();
        }else{
            stack.pop();
        }

    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}
