import java.util.Arrays;

/**
 * Created by sail on 12/14/16.
 * lengthOfLongestSubstring
 */
public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int i = 0, j = -1, ans = 0;
        for (char c : s.toCharArray()) {
            if (j < map[c]) {
                j = map[c];
            }
            map[c] = i;
            ans = Math.max(ans, i - j);
            i++;
        }
        return ans;
    }
}
