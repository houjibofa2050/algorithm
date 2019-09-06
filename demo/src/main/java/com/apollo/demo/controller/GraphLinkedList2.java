package com.apollo.demo.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 10:51
 * @email: fuguowen@fantaike.ai
 */
public class GraphLinkedList2 {
    public static void main(String[] args) {
        int numCourses=2;
        int[][] prerequisites={{1,0}};
        boolean b = canFinish(numCourses, prerequisites);

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphAdjList2 graphAdjList=new GraphAdjList2(numCourses);
        for(int i=0;i<numCourses;i++){
            graphAdjList.insertVex(i);
        }
        for (int i=0;i<prerequisites.length;i++){
            graphAdjList.directInsertEdge(prerequisites[i][0],prerequisites[i][1],1);
        }
        System.out.println(graphAdjList);

        //遍历图,获得入读为0的节点
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<graphAdjList.getNumOfVertex();i++){

            if(graphAdjList.getInDegree(i)==0){
                stack.add(i);
            }
        }
        System.out.println(stack);
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
//            graphAdjList.
        }


        return true;
    }


}
