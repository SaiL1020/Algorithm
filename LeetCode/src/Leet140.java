import java.util.*;

/**
 * Created by sail on 9/4/16.
 * Code one more line :)
 * Much thanks to: https://www.hrwhisper.me/leetcode-dynamic-programming/
 */
public class Leet140 {
    String st;
    Set<String> wd;
    List<String> ans;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        st = s;
        wd = wordDict;
        ans = new LinkedList<>();
        dfs(0, "");

        return ans;
    }

    public void dfs(int cur, String str) {
        if (cur == st.length()) {
            ans.add(str);
            return;
        }
        for (int i = cur; i < st.length(); i++) {

            if (wd.contains(st.substring(cur,i + 1)) && check(i + 1)) {
                if (str.equals(""))
                    dfs(i + 1, st.substring(cur,i + 1));
                else
                    dfs(i + 1, str + " " + st.substring(cur,i + 1));
            }
        }
    }

    public boolean check(int cur) {
        int len = st.length() - cur;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1] = dp[j] && (wd.contains(st.substring(j + cur, i + cur + 1)));
                if (dp[i + 1]) break;
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> wd = new HashSet<>(Arrays.asList("cat","cats","and","sand","dog"));
        List<String> ans = new Leet140().wordBreak(s, wd);
        for (String str: ans)
            System.out.print(str + " ");
        System.out.println();
    }
}
