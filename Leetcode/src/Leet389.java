/**
 * Created by sail on 8/27/16.
 * Code one more line :)
 */
public class Leet389 {
    public char findTheDifference(String s, String t) {
        long add = 0;
        for (int i = 0; i < s.length(); i++) {
            add -= s.charAt(i);
            add += t.charAt(i);
        }
        add += t.charAt(t.length() - 1);
        System.out.println(add);
        char ans = (char) add;
        return ans;
    }
}
