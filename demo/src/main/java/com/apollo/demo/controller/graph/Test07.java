package com.apollo.demo.controller.graph;

import java.text.DateFormatSymbols;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-29 10:37
 * @email: fuguowen@fantaike.ai
 */
public class Test07 {
    public static void main(String[] args) {
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }

            }
        }
        return count;
    }
    public static void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length || j>=grid[0].length|| grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
