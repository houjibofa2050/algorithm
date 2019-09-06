package com.apollo.demo.controller;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-17 11:57
 * @email: fuguowen@fantaike.ai
 */
public class MyAStar {

    //迷宫地图
     static int[][] map = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };
    public static class Grid {
        public int x;
        public int y;
        public int f;
        public int g;
        public int h;
        public Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public Grid getParent() {
            return parent;
        }

        public void setParent(Grid parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Grid{" +
                    "x=" + x +
                    ", y=" + y +
                    ", f=" + f +
                    ", g=" + g +
                    ", h=" + h +
                    ", parent=" + parent +
                    '}';
        }
    }
    public static void main(String[] args) {
        Grid start = new Grid(2, 1);
        Grid end = new Grid(2, 5);
        Grid grid = search(start, end);
        System.out.println(grid);
        Stack<Grid> stack = new Stack<>();
        while (grid.parent != null) {
            stack.push(grid);
            grid = grid.parent;
        }
        stack.push(start);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Grid pop = stack.pop();
            if (stack.isEmpty()) {
                sb.append("(" + pop.x + "," + pop.y + ")");
            } else {
                sb.append("(" + pop.x + "," + pop.y + ")" + "--->");
            }

        }
        System.out.println(sb.toString());
    }

    public static Grid search(Grid start,Grid end){
        List<Grid> openList=new ArrayList<>();
        List<Grid> closeList=new ArrayList<>();
        openList.add(start);
        while(!openList.isEmpty()){
            Grid minGrid = findListMin(openList);
            openList.remove(minGrid);
            closeList.add(minGrid);
            List<Grid> nerghborsList = getNerghbors(minGrid,openList,closeList);
            for (Grid grid : nerghborsList) {
                grid.initGrid(minGrid,end);
                openList.add(grid);
            }

            Grid grid = containElement2(end.x, end.y, openList);
            if(grid!=null){
                return grid;
            }
        }
        return null;
    }

    public static Grid findListMin(List<Grid> openList){
        Optional<Grid> max = openList.stream().max(new Comparator<Grid>() {
            @Override
            public int compare(Grid o1, Grid o2) {
                return -(o1.f - o2.f);
            }
        });
        return max.get();
    }
    /**
     * 找到邻接的顶点
     */
    public static List<Grid> getNerghbors(Grid grid,List<Grid> openList,List<Grid> closeList){
        List<Grid> list=new ArrayList<>(10);
        if(isValid(grid.x+1,grid.y,openList,closeList)){
            list.add(new Grid(grid.x+1,grid.y));
        }
        if(isValid(grid.x-1,grid.y,openList,closeList)){
            list.add(new Grid(grid.x-1,grid.y));
        }

        if(isValid(grid.x,grid.y+1,openList,closeList)){
            list.add(new Grid(grid.x,grid.y+1));
        }

        if(isValid(grid.x,grid.y-1,openList,closeList)){
            list.add(new Grid(grid.x,grid.y-1));
        }

        return list;


    }
    public static Boolean isValid(int x,int y,List<Grid> openList,List<Grid> closeList){
        int xMax=map.length;
        int yMax=map[0].length;
        if (x >= xMax || x < 0 || y >= yMax || y < 0) {
            return false;
        }
        if(map[x][y]==1){
            return false;
        }
        if (containElement(x, y, openList)) {
            return false;
        }

        if (containElement(x, y, closeList)) {
            return false;
        }
        return true;

    }

    public static Boolean containElement(int x,int y,List<Grid> openList){
        for (Grid grid : openList) {
            if(grid.x==x && grid.y==y){
                return true;
            }
        }
        return false;
    }

    public static Grid containElement2(int x,int y,List<Grid> openList){
        for (Grid grid : openList) {
            if(grid.x==x && grid.y==y){
                return grid;
            }
        }
        return null;
    }

}
