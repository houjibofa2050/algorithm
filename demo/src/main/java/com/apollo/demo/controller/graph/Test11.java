package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-30 14:03
 * @email: fuguowen@fantaike.ai
 */
public class Test11 {
    public static void main(String[] args) {
        WordDictionary wd=new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        wd.addWord("bat");
        boolean search = wd.search(".at");
        System.out.println(search);
    }
}
