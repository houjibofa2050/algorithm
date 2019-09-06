package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-31 22:42
 * @email: fuguowen@fantaike.ai
 */
public class Test15 {
    public static void main(String[] args) {
        int[][] M={{1,1,0},{1,1,0},{0,0,1}};
        int count = findCircleNum(M);
        System.out.println(count);
    }
    public static int findCircleNum(int[][] M) {
        DisjoinSet disjoinSet = new DisjoinSet(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j < M[i].length; j++) {
                if(M[i][j]==1){
                    disjoinSet.union(i, j);
                }
            }
        }
        return disjoinSet.count;

    }

}
