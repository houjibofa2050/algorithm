package com.apollo.demo.controller.graph;

import javafx.concurrent.Worker;

import java.util.*;

/**
 * @Description:
 * @Param:
 * @return:
 * @Author: fuguowen
 * @date: 2019-08-29 13:38
 * @email: fuguowen@fantaike.ai
 */
public class Test08 {
    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        String[] array={"hot","dot","dog","lot","log","cog"};
        List<String> wordList=new ArrayList<>(Arrays.asList(array));
        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);

    }

    public static class NodePair{
        String word;
        int step;

        public NodePair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map=new HashMap<>(16);
        constructGraph(beginWord,wordList,map);
        List<String> visitList=new ArrayList<>();
        Queue<NodePair> queue=new LinkedList<>();
        NodePair nodePair=new NodePair(beginWord,1);
        queue.add(nodePair);
        visitList.add(beginWord);
        while(!queue.isEmpty()){
            NodePair poll = queue.poll();
            if(poll.word.equals(endWord)){
                return poll.step;
            }
            List<String> list = map.get(poll.word);
            for (String s : list) {
                if(!visitList.contains(s)){
                    visitList.add(s);
                    queue.add(new NodePair(s,poll.step+1));
                }

            }
        }
        return 0;
    }

    public static void constructGraph(String beginWord, List<String> wordList, Map<String,List<String>> map) {
        wordList.add(beginWord);
        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i),new ArrayList<>());
        }

        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(connect(wordList.get(i),wordList.get(j))){
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

    }
    public static boolean connect(String word1,String word2){
        int count=0;
        if(word1.length()!=word2.length()){
            return false;
        }
        for(int i=0;i<word1.length();i++){
                if(word1.charAt(i)!=word2.charAt(i)){
                    count++;
                }
        }
        if(count==1){
            return true;
        }
        return false;
    }
}
