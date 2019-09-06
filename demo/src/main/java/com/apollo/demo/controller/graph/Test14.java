package com.apollo.demo.controller.graph;

import javax.sound.midi.Soundbank;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-31 22:34
 * @email: fuguowen@fantaike.ai
 */
public class Test14 {
    public static void main(String[] args) {
        DisjoinSet disjoinSet=new DisjoinSet(7);
        disjoinSet.union(0,1);
        disjoinSet.union(1,2);
        System.out.println(disjoinSet);


    }
}
