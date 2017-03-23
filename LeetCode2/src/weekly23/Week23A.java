package weekly23;

/**
 * Created by sail on 3/11/17.
 * Reverse String II
 */
public class Week23A {
    public String reverseStr(String s, int k) {
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (s.length() - i <= k) {
                for (int j = s.length() - 1; j >= i; j--) {
                    sbd.append(s.charAt(j));
                }
                break;
            }
            for (int j = i + k - 1; j >= i; j--) {
                sbd.append(s.charAt(j));
            }
            for (int j = i + k; j < i + 2 * k && j < s.length(); j++) {
                sbd.append(s.charAt(j));
            }
        }
        return sbd.toString();
    }
    private void run() {
        String s = "abcdefghij";
        int k = 3;
        System.out.println(reverseStr(s, k));
    }
    public static void main(String[] args) {
        new Week23A().run();
    }
}
