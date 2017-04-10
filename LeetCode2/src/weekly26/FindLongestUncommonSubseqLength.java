package weekly26;

import java.util.*;

/**
 * author:      SaiL1020
 * time:        4/2/17 10:49 AM
 * project:     Algorithm
 */
public class FindLongestUncommonSubseqLength {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) return -1;

        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        if (map.size() == 1) return -1;

        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        // sort the elements in list by the length of strings in descending order
        list.sort((a,b)->(b.getKey().length() - a.getKey().length()));

        List<String> pre = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : list) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                if (pre.isEmpty() || !pre.isEmpty() && !isSubseqFromList(entry.getKey(), pre))
                    return entry.getKey().length();
            }
            pre.add(key);
        }
        return -1;
    }
    // check if subStr is the subsequence of any string in the list
    private boolean isSubseqFromList(String subStr, List<String> list) {
        for (String str : list) {
            if (isSubseq(subStr, str)) return true;
        }
        return false;
    }
    // assume: subStr.length() <= mainStr.length()
    private boolean isSubseq(String subStr, String mainStr) {
        for (int i = 0, j = 0; i < subStr.length(); i++) {
            while (j < mainStr.length() && mainStr.charAt(j) != subStr.charAt(i)) {
                ++j;
            }
            if (j == mainStr.length()) return false;
            ++j;    // REMIND: move the position of mainStr afterwards
        }
        return true;
    }
}
