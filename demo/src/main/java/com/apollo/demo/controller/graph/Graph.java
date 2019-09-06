package com.apollo.demo.controller.graph;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-23 13:50
 * @email: fuguowen@fantaike.ai
 */
public class Graph {
    /** 图中顶点的个数 */
    private int v;
    /** 邻接链表 */
    private LinkedList<Integer>[] adj;

    private Boolean found=false;

    /**
     * 创建指定大小的图
     * @param v
     */
    public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }
    /**
     * 为无向图添加边
     * @param s
     * @param t
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 指定顶点的邻接顶点
     *
     */
    public List<Integer> getAdjVertex(int s){
       return adj[s];
    }

    /**
     * 图的广度优先搜索
     * 从s到t的最短路径
     * @param s
     * @param t
     */
    public void bfs(int s,int t){
        if(s==t){
            return ;
        }
        boolean[] visited=new boolean[v];
        visited[s]=true;
        Queue<Integer> queue=new LinkedList<>();
        int[] prev=new int[v];
        for(int i=0;i<v;i++){
            prev[i]=-1;
        }
        queue.add(s);
        while(!queue.isEmpty()){
            Integer w = queue.poll();
            for(int i=0;i<adj[w].size();i++){
                Integer q = adj[w].get(i);
                if(!visited[q]){
                    prev[q]=w;
                    if(q==t){
                        break ;
                    }
                    visited[q]=true;
                    queue.add(q);
                }
            }
        }

        Stack<Integer> stack=new Stack<>();
        stack.push(t);
        while(prev[t]!=-1){
            stack.add(prev[t]);
            t=prev[t];
        }

        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            if(stack.isEmpty()){
                System.out.print(pop);
            }else{
                System.out.print(pop+"--->");
            }
        }
        System.out.println();
    }

    public void dfs(int s,int t){
        found=false;
        boolean[] visited=new boolean[v];
        int[] prev=new int[v];
        for(int i=0;i<v;i++){
            prev[i]=-1;
        }
        visited[s]=true;
        recurDfs(s,t,visited,prev);

        Stack<Integer> stack=new Stack<>();
        stack.push(t);
        while(prev[t]!=-1){
            stack.add(prev[t]);
            t=prev[t];
        }

        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            if(stack.isEmpty()){
                System.out.print(pop);
            }else{
                System.out.print(pop+"--->");
            }
        }

    }
    public void recurDfs(int w,int t,boolean[] visited,int[] prev){
        if(found==true){
            return ;
        }
        visited[w]=true;
        if(w==t){
            found=true;
            return ;
        }
        for(int i=0;i<adj[w].size();i++){
            Integer q = adj[w].get(i);
            if(!visited[q]){
                prev[q]=w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 创建图
         */
        Graph graph=new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        System.out.println(graph);
        graph.bfs(0,7);
        graph.dfs(0,7);
    }
}
