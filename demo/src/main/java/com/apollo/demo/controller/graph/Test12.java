package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-30 14:03
 * @email: fuguowen@fantaike.ai
 */
public class Test12 {
    public static void main(String[] args) {
        WordDictionary wd=new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        boolean search = wd.search("pad");
        boolean search2= wd.search("bad");
        boolean search3= wd.search(".ad");
        boolean search4= wd.search("b..");
        System.out.println(search);
        System.out.println(search2);
        System.out.println(search3);
        System.out.println(search4);
    }
}
