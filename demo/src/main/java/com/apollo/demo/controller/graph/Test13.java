package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-31 22:11
 * @email: fuguowen@fantaike.ai
 */
public class Test13 {
    public static int findCircleNum(int[][] M) {
        int[] visited=new int[M.length];
        int count=0;
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                searchDfs(i,M,visited);
                count++;
            }

        }
        return count;
    }
    public static void searchDfs(int i,int[][] M,int[] visited){
        visited[i]=1;
        for(int j=0;j<M[i].length;j++){
            if(visited[j]==0 && M[i][j]==1){
                searchDfs(j,M,visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M={{1,1,0},{1,1,0},{0,0,1}};
        int count = findCircleNum(M);
        System.out.println(count);
    }

}
