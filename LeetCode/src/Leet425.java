import java.util.*;

/**
 * Created by sail on 11/4/16.
 * 425. Word Squares
 */
public class Leet425 {
    private Map<String, Set<String>> map;
    private List<List<String>> ans;
    private int wid;
    public List<List<String>> wordSquares(String[] words) {
        ans = new ArrayList<>();
        int len = words.length;
        if (len == 0) return ans;
        wid = words[0].length();
        map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < wid; i++) {
                String sub = word.substring(0, i);
                Set<String> set = map.getOrDefault(sub, new HashSet<>());
                set.add(word);
                map.put(sub, set);
            }
        }
        build(0, new ArrayList<>());
        return ans;
    }
    private void build(int k, List<String> list) {
        if (k == wid) {
            ans.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sbf = new StringBuilder();
        for (String str : list)
            sbf.append(str.charAt(k));
        Set<String> set = map.get(sbf.toString());
        if (set == null) return;
        for (String str : set) {
            list.add(str);
            build(k + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private void run() {
        String[] words = new String[]{"area","lead","wall","lady","ball"};
        for (List<String> list : wordSquares(words)) {
            for (String word : list) {
                System.out.println(word);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new Leet425().run();
    }
}
