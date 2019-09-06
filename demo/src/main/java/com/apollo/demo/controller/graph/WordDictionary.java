package com.apollo.demo.controller.graph;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-30 13:36
 * @email: fuguowen@fantaike.ai
 */
public class WordDictionary {
    TrieNode root;

    public static class TrieNode{
        TrieNode[] childs;
        boolean isEnd;

        public TrieNode() {
            this.childs = new TrieNode[26];
        }
    }


    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root =new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String world) {
        TrieNode node=root;
        for(int i=0;i<world.length();i++){
            char c = world.charAt(i);
            if(node.childs[c-'a']==null) {
                node.childs[c - 'a'] =new TrieNode();
            }
            node=node.childs[c-'a'];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node=root;
        boolean flag= blurrySearch(node, word, 0);
        return flag;
    }

    public boolean blurrySearch(TrieNode node,String word,int i){
        if(word==null){
            return false;
        }
        if (i == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node!=null && node.childs[j] != null) {
                    if(blurrySearch(node.childs[j], word, i + 1)){
                        return true;
                    }{
                        continue;
                    }
                }
            }
        } else {
            if (node.childs[c - 'a'] != null) {
                return blurrySearch(node.childs[c - 'a'], word, i + 1);
            } else {
                return false;
            }
        }
        return false;
    }
}
