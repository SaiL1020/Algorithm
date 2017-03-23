/**
 * Created by sail on 9/7/16.
 * Code one more line :)
 */
public class Leet13 {
    Object[] map = new Object[]{'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000};
    public int romanToInt(String s) {
        int len = s.length();
        int ans = getNum(s.charAt(len - 1));
        int pre = getNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getNum(s.charAt(i));
            if (cur > pre) ans -= pre;
            else ans += pre;
            pre = cur;
        }
        return ans;
    }
    public int getNum(char ch) {
        for (int i = 0; i < map.length; i += 2) {
            if ((char)map[i] == ch)
                return (int)map[i + 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new Leet13().romanToInt("DCCCXC");
        System.out.println(ans);
    }
}
