package com.apollo.demo.controller;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 10:36
 * @email: fuguowen@fantaike.ai
 */

/**
 * 边表节点
 */
public class EdgeNode {
    int adjVex;
    int weight;
    EdgeNode next;

    public EdgeNode(int adjVex) {
        this.adjVex = adjVex;
    }

    public EdgeNode(int adjVex, int weight) {
        this.adjVex = adjVex;
        this.weight = weight;
    }

    public EdgeNode(int adjVex, int weight, EdgeNode next) {
        this.adjVex = adjVex;
        this.weight = weight;
        this.next = next;
    }
}
