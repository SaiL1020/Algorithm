import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sail on 9/15/16.
 * Code one more line :)
 */
public class Leet22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(ans, n, n, "");
        return ans;
    }

    public void gen(List<String> ans, int left, int right, String str) {
        //System.out.println(str);
        if (right == 0) {
            ans.add(str);
            return;
        }
        if (left > 0)
            gen(ans, left - 1, right, str + "(");
        if (left < right)
            gen(ans, left, right - 1, str + ")");
    }

    public void add(List<String> ans, List<String> tmp, char c) {
        for (String s : ans) {
            s += c;
            tmp.add(s);
        }
    }

    public void run() {
        int num;
        Scanner sc = new Scanner(System.in);
        while ((num = sc.nextInt()) != 0) {
            List<String> ans = generateParenthesis(num);
            for (String s : ans) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new Leet22().run();
    }
}
