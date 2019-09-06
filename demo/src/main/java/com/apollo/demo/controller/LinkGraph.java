package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 14:17
 * @email: fuguowen@fantaike.ai
 */

/**
 * 邻接链表
 */
public class LinkGraph {

    public static class EdgeNode{
        int adjvex;
        int weight;
        EdgeNode next;

        public EdgeNode(int adjvex, int weight) {
            this.adjvex = adjvex;
            this.weight = weight;
        }
    }

    public static class VertexNode{
        int data;
        EdgeNode firstEdge;
    }

    int vertexNums;
    int edgeNums;
    VertexNode[] vertexNodes;

    public LinkGraph(int vertexNums,int edgeNums) {
        this.vertexNums=vertexNums;
        this.edgeNums=edgeNums;
        vertexNodes=new VertexNode[100];

    }

    public LinkGraph(int vertexNums,int edgeNums,int[][] paths) {
        this.vertexNums=vertexNums;
        this.edgeNums=edgeNums;
        
    }

    public void insertVertex(int vertex){

    }
    public void  insertEdge(int v1,int v2,int weight) {
        EdgeNode edgeNode = new EdgeNode(v2, weight);
        System.out.println(vertexNodes[v1]);
        if(vertexNodes[v1]==null){

        }
        edgeNode.next=vertexNodes[v1].firstEdge;
        vertexNodes[v1].firstEdge=edgeNode;



        EdgeNode edgeNode2 = new EdgeNode(v1, weight);
        edgeNode2.next=vertexNodes[v1].firstEdge;
        vertexNodes[v2].firstEdge=edgeNode2;
    }

}
