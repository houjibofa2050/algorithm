package com.apollo.demo.controller;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 17:16
 * @email: fuguowen@fantaike.ai
 */
public class Test31 {
    public static void main(String[] args) {
        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(order);
        System.out.println(Arrays.toString(order));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化图 键---值   键是表头节点   值是表边节点
        Map<Integer,List<Integer>> map=new HashMap<>(16);
        int[] degrees=new int[numCourses];
        int[] nums=new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            int end=prerequisites[i][0];
            int start=prerequisites[i][1];
            List<Integer> list = map.get(start);
            if(list!=null){
                list.add(end);
            }else{
                map.put(start,new ArrayList<>());
                map.get(start).add(end);
            }
            degrees[end]++;
        }
        int j=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<degrees.length;i++){
            if(degrees[i]==0){
                queue.offer(i);
                nums[j]=i;
                j++;
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            count++;
            List<Integer> intList = map.get(poll);
            if(intList==null){
                continue;
            }
            for(int i=0;i<intList.size();i++){
                int idx=intList.get(i);
                degrees[idx]--;
                if(degrees[idx]==0){
                    queue.offer(idx);
                    nums[j]=idx;
                    j++;
                }
            }
        }
        if(count==numCourses){
            return nums;
        }
        return new int[]{};
    }
}
