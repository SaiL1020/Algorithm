/**
 * Created by sail on 10/20/16.
 * Code one more line :)
 */

import java.util.*;
import java.io.*;

public class Leet127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord) || wordList.isEmpty())
            return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        int editDis = 1, len = beginWord.length();
        que.add(beginWord);
        que.add(null);
        vis.add(beginWord);
        while (!que.isEmpty()) {
            String cur = que.poll();
            if (cur == null) {
                editDis++;
                if (!que.isEmpty())
                    que.add(null);
                continue;
            }
            for (int i = 0; i < len; i++) {
                StringBuilder sbd = new StringBuilder(cur);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (sbd.charAt(i) == c) continue;
                    sbd.setCharAt(i, c);
                    String newStr = sbd.toString();
                    if (endWord.equals(newStr))
                        return editDis + 1;
                    if (wordList.contains(newStr) && !vis.contains(newStr)) {
                        que.add(newStr);
                        vis.add(newStr);
                    }
                }
            }
        }
        return 0;
    }

    private void run() {
        String b = "hit", e = "cog";
        Set<String> l = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(b, e, l));
    }
    public static void main(String[] args) {
        new Leet127().run();
    }
}
