import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sail on 10/1/16.
 * Code one more line :)
 */
public class CF722B {
    static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(line[i]);
        }
        boolean isVP = true;
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            if (!isVP) continue;
            int cur = 0;
            for (String s : line) {
                cur += numOfVersePattern(s);
            }
            if (cur != p[i]) isVP = false;
        }
        System.out.println(isVP ? "YES" : "NO");
    }
    public static int numOfVersePattern(String s) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }
}

