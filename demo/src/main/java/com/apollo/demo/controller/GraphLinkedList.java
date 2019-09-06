package com.apollo.demo.controller;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 10:51
 * @email: fuguowen@fantaike.ai
 */
public class GraphLinkedList {
    public static void main(String[] args) {
        GraphAdjList graphAdjList=new GraphAdjList(10);
        graphAdjList.insertVex(1);
        graphAdjList.insertVex(2);
        graphAdjList.insertVex(3);
        graphAdjList.insertVex(4);
        boolean b = graphAdjList.insertEdge(1, 2, 5);
        System.out.println(b);
        boolean b1 = graphAdjList.insertEdge(1, 3, 6);
        System.out.println(b1);
        Queue<Integer> queue=new LinkedList<>();
        System.out.println(graphAdjList);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphAdjList graphAdjList=new GraphAdjList(numCourses);
        for(int i=0;i<numCourses;i++){
            graphAdjList.insertVex(i);
        }

        return true;
    }


}
