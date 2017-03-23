import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sail on 11/5/16.
 * frequency Sort
 */
public class Leet451 {
    public String frequencySort(String s) {
        int[] cnt = new int[256];
        for (char c : s.toCharArray())
            cnt[c]++;
        Map<Integer, List<Character>> map = new HashMap<>();
        List<Character> list;
        for (int i = 0; i < 256; i++) {
            if (cnt[i] == 0) continue;
            list = map.getOrDefault(cnt[i], new LinkedList<>());
            list.add((char) i);
            map.put(cnt[i], list);
        }
        StringBuilder sbd = new StringBuilder();
        for (int k = s.length(); k > 0; k--) {
            if ((list = map.get(k)) != null) {
                for (char c : list)
                    for (int i = 0; i < k; i++)
                        sbd.append(c);
            }
        }
        return sbd.toString();
    }
//    public String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort((e1, e2)->(e2.getValue() - (e1.getValue())));
//        StringBuilder sbd = new StringBuilder();
//        for (Map.Entry<Character, Integer> en : list) {
//            for (int i = 0 ; i < en.getValue(); i++) {
//                sbd.append(en.getKey());
//            }
//        }
//        return sbd.toString();
//    }

    public void run() {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static void main(String[] args) {
        new Leet451().run();
    }
}
