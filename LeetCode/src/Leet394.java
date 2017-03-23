/**
 * Created by sail on 9/23/16.
 * Code one more line :)
 */
public class Leet394 {
    int shift, n;
    char[] ch;
    public String decodeString(String s) {
        n = s.length();
        shift = 0;
        ch = s.toCharArray();
        String ans = "";
        while (shift < n) {
            ans += dfs();
        }
        return ans;
    }
    public String dfs() {
        int i = shift;
        if (i == n) return "";
        StringBuilder sbd = new StringBuilder();
        if (!Character.isDigit(ch[i])) {
            while (i < n && !Character.isDigit(ch[i]) && ch[i] != ']') {
                sbd.append(ch[i++]);
            }
            shift = i;
            return sbd.toString();
        }
        int cnt = 0;
        String tmp = "";
        while (i < n && Character.isDigit(ch[i])) {
            cnt = cnt * 10 + ch[i] - '0';
            i++;
        }
        i++;    // skip '['
        while (i < n && !Character.isDigit(ch[i]) && ch[i] != ']') {
            tmp += ch[i++];
        }
        while (i < n && ch[i] != ']') {
            shift = i;
            tmp += dfs();
            i = shift;
        }
        while (cnt-- > 0) {
            sbd.append(tmp);
        }
        i++;    // skip ']'
        shift = i;
        return sbd.toString();
    }

    public void run() {
        String str = "3[a2[c]d]";
        System.out.println(decodeString(str));
    }
    public static void main(String[] args) {
        new Leet394().run();
    }
}
