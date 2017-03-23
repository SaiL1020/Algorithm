import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sail on 9/3/16.
 * Code one more line :)
 */
public class Leet139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                dp[i + 1] = dp[j] && wordDict.contains(s.substring(j,i+1));
                if (dp[i + 1]) break;
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> wd = new HashSet<>(Arrays.asList("leet", "code"));
        System.out.println(new Leet139().wordBreak(s, wd));
    }
}
