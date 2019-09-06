package com.apollo.demo.controller;

import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-09 09:37
 * @email: fuguowen@fantaike.ai
 */
public class Test27 {
    public static void main(String[] args) {
        int N=3;
        int[][] trust={{1,3},{2,3}};
        int judge = findJudge(N, trust);
        System.out.println(judge);
    }

    public static int findJudge(int N, int[][] trust) {
        int[] in=new int[N+1];
        int[] out=new int[N+1];

        for(int i=0;i<trust.length;i++){
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }

        for(int i=1;i<N+1;i++){
            if(in[i]==(N-1) && out[i]==0){
                return i;
            }
        }
        return -1;
    }
}
