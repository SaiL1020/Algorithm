import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sail on 9/15/16.
 * Code one more line :)
 */
public class Leet17 {
    String[] dial = new String[]{
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>(), tmp = new LinkedList<>();
        if (digits.equals("")) return ans;
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            System.out.println(num);
            if (1 < num && num < 10) {
                for (String s : ans) {
                    for (int j = 0; j < dial[num].length(); j++) {
                        String ts = s + dial[num].charAt(j);
                        System.out.println(ts);
                        tmp.add(ts);
                    }
                }
            } else {
                switch (digits.charAt(i)) {
                    case '0': add(ans, tmp, ' '); break;
                    case '1': break;
                    case '*': add(ans, tmp, '*'); break;
                    case '#': add(ans, tmp, '#'); break;
                }
            }
            ans = new LinkedList<>(tmp);
//            for (String s : ans) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
            tmp.clear();
        }
        return ans;
    }
    public void add(List<String> ans, List<String> tmp, char c) {
        for (String s : ans) {
            s += c;
            tmp.add(s);
        }
    }

    public void run() {
        String str;
        Scanner sc = new Scanner(System.in);
        while (!(str = sc.nextLine()).equals("")) {
            List<String> ans = letterCombinations(str);
            for (String s : ans) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new Leet17().run();
    }
}
