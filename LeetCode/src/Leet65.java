import java.util.Scanner;

/**
 * Created by sail on 9/8/16.
 * Code one more line :)
 */
public class Leet65 {
    public static boolean isNumber(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        for (char aStr : str) {
            if (!(('0' <= aStr && aStr <= '9') ||
                    aStr == ' ' ||
                    aStr == '.' ||
                    aStr == 'e' ||
                    aStr == '-' ||
                    aStr == '+')) {
                return false;
            }
        }
        boolean dot = false, eee = false, space = false, digit = false, minus= false;
        char ch = ' ', last = ' ';
        for (int i = 0; i < len; i++) {
            ch = str[i];

            if (ch == '-' || ch == '+') {
                //System.out.println((last != ' ') + " " + minus);

                if ((i > 0 && str[i-1] == 'e') && digit) {
                    minus = true;
                    continue;
                }
                if (last != ' ' || (minus)) return false;
                minus = true;
            }
            if (ch != ' ') last = ch;
            if (space && ch != ' ') return false;
            if ('0' <= ch && ch <= '9') {
                digit = true;
                continue;
            }
            if (!digit) {                       // digit not shown
                if (ch == ' ') {
                    if (dot || minus) return false;
                    continue;
                }
                if (ch == 'e') return false;
                if (ch == '.') {
                    if (dot) return false;
                    dot = true;
                }
                continue;
            }
            if (ch == '.') {
                if (dot || eee) return false;
                dot = true;
                continue;
            }
            if (ch == 'e') {
                if (eee) return false;
                eee = true;
                continue;
            }
            if (ch == ' ') {
                space = true;
            }
        }
        return !(last == 'e' || !digit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            System.out.println(isNumber(str));
        }
    }
}
