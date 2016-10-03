import java.util.*;

/**
 * Created by sail on 9/16/16.
 * Code one more line :)
 */
public class Leet30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (words.length == 0 || s.length() == 0) return ans;
        int sLen = s.length(), wLen = words[0].length();
        int winLen = wLen * words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i < wLen; i++) {
            Map<String, Integer> curMap = new HashMap<>();
            int cnt = 0, start = i;
            for (int j = i; j + wLen <= sLen; j += wLen) {
                if (start + winLen > sLen) break;
                String str = s.substring(j, j + wLen);
                System.out.println("start: " + start + " " + j + " " + str);
                if (!map.containsKey(str)) {
                    curMap.clear();
                    start = j + wLen;
                    cnt = 0;
                } else {
                    if (j == start + winLen) {
                        String rem = s.substring(start, start + wLen);
                        start += wLen;
                        int val = curMap.get(rem);
                        if (val == 1) curMap.remove(rem);
                        else curMap.put(rem, curMap.get(rem) - 1);
                        if (val - 1 >= map.get(rem)) cnt--;
                    }
                    curMap.put(str, curMap.getOrDefault(str, 0) + 1);
                    if (curMap.get(str) > map.get(str)) cnt++;
                    if (cnt == 0 && j + wLen == start + winLen) {
                        ans.add(start);
                    }
                }
            }
        }
        return ans;
    }

    public void run() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> ans = findSubstring(s, words);
        for (int k : ans) System.out.print(k + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        new Leet30().run();
    }
}
