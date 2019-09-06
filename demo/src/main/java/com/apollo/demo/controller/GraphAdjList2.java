package com.apollo.demo.controller;

import java.lang.reflect.Array;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 11:56
 * @email: fuguowen@fantaike.ai
 */
public class GraphAdjList2<E>  {

    // 邻接表中表对应的链表的顶点
    private static class ENode {
        int adjvex; // 邻接顶点序号
        int weight;// 存储边或弧相关的信息，如权值
        ENode nextadj; // 下一个邻接表结点

        public ENode(int adjvex, int weight) {
            this.adjvex = adjvex;
            this.weight = weight;
        }
    }

    // 邻接表中表的顶点
    private static class VNode<E> {
        E data; // 顶点信息
        int in;
        ENode firstadj; // //邻接表的第1个结点

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public ENode getFirstadj() {
            return firstadj;
        }

        public void setFirstadj(ENode firstadj) {
            this.firstadj = firstadj;
        }
    };

     VNode<E>[] vexs; // 顶点数组
    int numOfVexs;// 顶点的实际数量
    int maxNumOfVexs;// 顶点的最大数量
    boolean[] visited;// 判断顶点是否被访问过

    @SuppressWarnings("unchecked")
    public GraphAdjList2(int maxNumOfVexs) {
        this.maxNumOfVexs = maxNumOfVexs;
        vexs = (VNode<E>[]) Array.newInstance(VNode.class, maxNumOfVexs);
    }

    // 得到顶点的数目
    public int getNumOfVertex() {
        return numOfVexs;
    }

    // 插入顶点
    public boolean insertVex(E v) {
        if (numOfVexs >= maxNumOfVexs){
            return false;
        }
        VNode<E> vex = new VNode<E>();
        vex.data = v;
        vexs[numOfVexs++] = vex;
        return true;
    }

    // 删除顶点
    public boolean deleteVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].data.equals(v)) {
                for (int j = i; j < numOfVexs - 1; j++) {
                    vexs[j] = vexs[j + 1];
                }
                vexs[numOfVexs - 1] = null;
                numOfVexs--;
                ENode current;
                ENode previous;
                for (int j = 0; j < numOfVexs; j++) {
                    if (vexs[j].firstadj == null)
                        continue;
                    if (vexs[j].firstadj.adjvex == i) {
                        vexs[j].firstadj = null;
                        continue;
                    }
                    current = vexs[j].firstadj;
                    while (current != null) {
                        previous = current;
                        current = current.nextadj;
                        if (current != null && current.adjvex == i) {
                            previous.nextadj = current.nextadj;
                            break;
                        }
                    }
                }
                for (int j = 0; j < numOfVexs; j++) {
                    current = vexs[j].firstadj;
                    while (current != null) {
                        if (current.adjvex > i)
                            current.adjvex--;
                        current = current.nextadj;
                    }
                }
                return true;
            }
        }
        return false;
    }

    // 定位顶点的位置
    public int indexOfVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].data.equals(v)) {
                return i;
            }
        }
        return -1;
    }

    // 定位指定位置的顶点
    public E valueOfVex(int v) {
        if (v < 0 || v >= numOfVexs)
            return null;
        return vexs[v].data;
    }

    // 插入边
    public boolean unDirectInsertEdge(int v1, int v2, int weight) {
        System.out.println("numOfVexs: "+numOfVexs);
        System.out.println("numOfVexs: "+numOfVexs);
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }

        ENode vex1 = new ENode(v2, weight);


        // 索引为index1的顶点没有邻接顶点
        if (vexs[v1].firstadj == null) {
            vexs[v1].firstadj = vex1;
        }
        // 索引为index1的顶点有邻接顶点
        else {
            vex1.nextadj = vexs[v1].firstadj;
            vexs[v1].firstadj = vex1;
        }

        ENode vex2 = new ENode(v1, weight);
        // 索引为index2的顶点没有邻接顶点
        if (vexs[v2].firstadj == null) {
            vexs[v2].firstadj = vex2;
        }
        // 索引为index1的顶点有邻接顶点
        else {
            vex2.nextadj = vexs[v2].firstadj;
            vexs[v2].firstadj = vex2;
        }
        return true;
    }

    // 插入边
    public boolean directInsertEdge(int v1, int v2, int weight) {

        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }

        ENode vex1 = new ENode(v2, weight);
        vexs[v2].in++;

        // 索引为index1的顶点没有邻接顶点
        if (vexs[v1].firstadj == null) {
            vexs[v1].firstadj = vex1;
        }
        // 索引为index1的顶点有邻接顶点
        else {
            vex1.nextadj = vexs[v1].firstadj;
            vexs[v1].firstadj = vex1;
        }


        return true;
    }

    // 插入边
    public int getInDegree(int v1) {

        return vexs[v1].in;
    }

    // 删除边
    public boolean deleteEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        // 删除索引为index1的顶点与索引为index2的顶点之间的边
        ENode current = vexs[v1].firstadj;
        ENode previous = null;
        while (current != null && current.adjvex != v2) {
            previous = current;
            current = current.nextadj;
        }
        if (current != null)
            previous.nextadj = current.nextadj;
        // 删除索引为index2的顶点与索引为index1的顶点之间的边
        current = vexs[v2].firstadj;
        while (current != null && current.adjvex != v1) {
            previous = current;
            current = current.nextadj;
        }
        if (current != null)
            previous.nextadj = current.nextadj;
        return true;
    }

    // 得到边
    public int getEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        ENode current = vexs[v1].firstadj;
        while (current != null) {
            if (current.adjvex == v2) {
                return current.weight;
            }
            current = current.nextadj;
        }
        return 0;
    }



    // 深度优先搜索遍历
    public String depthFirstSearch(int v) {
        return null;
    }

    // 广度优先搜索遍历
    public String breadFirstSearch(int v) {
        return null;
    }

    // 实现Dijkstra算法
    public int[] dijkstra(int v) {
        return null;
    }


}
