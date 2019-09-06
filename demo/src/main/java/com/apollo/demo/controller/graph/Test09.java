package com.apollo.demo.controller.graph;

import com.apollo.demo.controller.TreeNode;

import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-30 10:14
 * @email: fuguowen@fantaike.ai
 */
public class Test09 {
    public static void main(String[] args) {
        TrieTree trieTree=new TrieTree();
        trieTree.insert("hello");
        System.out.println(trieTree);
        boolean flag = trieTree.search("w");
        System.out.println(flag);

        boolean flag2 = trieTree.startWithPrefix("hell");
        System.out.println(flag2);



        boolean flag3 = trieTree.startWithPrefix("w");
        System.out.println(flag3);

        trieTree.insert("world");
        List<String> allWord = trieTree.getAllWord();
        System.out.println(allWord);

    }
}
