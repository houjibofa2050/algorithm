package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 10:40
 * @email: fuguowen@fantaike.ai
 */

/**
 * 点表节点
 */
public class VertexNode {
    int data;
    EdgeNode  firstEdge;

    public VertexNode() {
    }

    public VertexNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }
}
