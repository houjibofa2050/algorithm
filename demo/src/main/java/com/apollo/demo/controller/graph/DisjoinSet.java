package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-31 22:29
 * @email: fuguowen@fantaike.ai
 */
public class DisjoinSet {
    int[] id;
    int[] size;
    int count;

    public DisjoinSet(int n) {
        id=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
            size[i]=1;
        }
        count=n;
    }

    public int find(int p){
        while(p!=id[p]){
            p=id[p];
        }
        return p;
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);
        if(i==j){
            return;
        }
        if(size[i]<size[j]){
            id[i]=j;
            size[j]+=size[i];
        }else{
            id[j]=i;
            size[i]+=size[j];
        }
        count--;
    }
}
