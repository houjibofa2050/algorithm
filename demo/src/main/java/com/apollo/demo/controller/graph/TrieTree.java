package com.apollo.demo.controller.graph;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-30 10:04
 * @email: fuguowen@fantaike.ai
 */
public class TrieTree {
    TrieNode root;

    public TrieTree() {
        this.root =new TrieNode();
    }

    public static class TrieNode{
        TrieNode[] childs;
        boolean isEnd;

        public TrieNode() {
            this.childs = new TrieNode[26];
        }

        public TrieNode getNode(TrieNode node,char c){
            return node.childs[c-'a'];
        }
    }
    public void insert(String world){
        TrieNode node=root;
        for(int i=0;i<world.length();i++){
            char c = world.charAt(i);
            if(node.childs[c-'a']==null) {
                node.childs[c - 'a'] = new TrieNode();
            }
            node=node.childs[c-'a'];
        }
        node.isEnd=true;
    }

    public boolean search(String world){
        TrieNode node = searchPrefix(world);
        if(node!=null && node.isEnd==true){
            return true;
        }
        return false;
    }


    /**
     * 把字符串作为前缀搜索
     * @param prefix
     * @return
     */
    public boolean startWithPrefix(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

    public TrieNode searchPrefix(String world){
        TrieNode node=root;
        for(int i=0;i<world.length();i++){
            char c = world.charAt(i);
            if(node.childs[c-'a']==null) {
                return null;
            }else{
                node=node.childs[c-'a'];
            }
        }
        return node;
    }

    public List<String> getAllWord(){
        TrieNode node=root;
        List<String> list=new ArrayList<>();
        String world="";
        generateAllWorld(node,world,list);
        return list;

    }
    public void generateAllWorld(TrieNode root, String world, List<String> list){
        for(int i=0;i<26;i++){
            if(root.childs[i]!=null){
                world+=(char)(i+'a');
                if(root.childs[i].isEnd==true){
                    list.add(world);
                }
                generateAllWorld(root.childs[i],world,list);
                world=world.substring(0,world.length()-1);
            }
        }
    }


}
