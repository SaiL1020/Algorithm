/**
 * Created by sail on 10/20/16.
 * Code one more line :)
 */

import java.util.*;
import java.io.*;

public class Leet126 {
    List<List<String>> ans;
    Map<String, List<String>> adjMap;
    Map<String, Integer> minDisMap;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        ans = new LinkedList<>();
        if (beginWord.equals(endWord)) {
            ans.add(new LinkedList<>(Arrays.asList(beginWord)));
            return ans;
        }
        if (wordList.isEmpty())
            return ans;
        Queue<String> que = new LinkedList<>();

        adjMap = new HashMap<>();
        minDisMap = new HashMap<>();
        wordList.add(endWord);
        for (String str : wordList)
            minDisMap.put(str, Integer.MAX_VALUE);
        minDisMap.put(beginWord, 0);
        int minDis = Integer.MAX_VALUE, len = beginWord.length();
        que.add(beginWord);

        while (!que.isEmpty()) {
            String cur = que.poll();
            int curDis = minDisMap.get(cur) + 1;    // how many step to get cur
            if (curDis > minDis) continue;
            for (int i = 0; i < len; i++) {
                StringBuilder sbd = new StringBuilder(cur);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (sbd.charAt(i) == c) continue;
                    sbd.setCharAt(i, c);
                    String newStr = sbd.toString();

                    if (wordList.contains(newStr)) {
//                        System.out.println(cur + " " + newStr);
//                        System.out.println(curDis + " " + minDisMap.get(newStr));
                        if (curDis > minDisMap.get(newStr))
                            continue;
                        else if (curDis < minDisMap.get(newStr)) {
                            que.add(newStr);
                            minDisMap.put(newStr, curDis);
                        }

                        List<String> list = adjMap.getOrDefault(newStr, new LinkedList<>());
                        list.add(cur);
                        adjMap.put(newStr, list);
                        if (endWord.equals(newStr))
                            minDis = curDis;
                    }
                }
            }
        }
//        System.out.println(minDis);
        ans = new LinkedList<>();
        backTrace(beginWord, endWord, new LinkedList<>());
        return ans;
    }
    private void backTrace(String b, String e, List<String> l) {
        if (b.equals(e)) {
            l.add(0, b);
            ans.add(new LinkedList<>(l));
            l.remove(0);
            return;
        }
        l.add(0, e);
        if (adjMap.get(e) != null)
            for (String s : adjMap.get(e))
                backTrace(b, s, l);
        l.remove(0);
    }

    private void run() {
        String b = "hit", e = "cog";
        Set<String> l = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(findLadders(b, e, l));
    }
    public static void main(String[] args) {
        new Leet126().run();
    }
}
