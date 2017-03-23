import java.util.Scanner;
/**
 * Created by sail on 9/16/16.
 * Code one more line :)
 */
public class Leet32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;

        int n = s.length(), open = 0;
        int[] last = new int[n];
        char[] ch = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') open++;
            if (ch[i] == ')' && open > 0) {
                last[i] = 2 + last[i - 1] + (i - 2 - last[i - 1] > 0 ? last[i - 2 - last[i - 1]] : 0);
                open--;
            }
            if (last[i] > ans)
                ans = last[i];
        }
        return ans;
    }

    public void run() {
        String str;
        Scanner sc = new Scanner(System.in);
        while (!(str = sc.nextLine()).equals("")) {
            System.out.println(longestValidParentheses(str));
        }
    }
    public static void main(String[] args) {
        new Leet32().run();
    }
}
