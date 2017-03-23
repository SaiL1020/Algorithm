/**
 * Created by sail on 8/28/16.
 * Code one more line :)
 */
public class Leet387 {
    public int firstUniqChar(String s) {
        int[] vis = new int[30];
        for (char c: s.toCharArray()) {
            vis[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (vis[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
