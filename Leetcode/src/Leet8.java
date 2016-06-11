/**
 * Created by sail on 6/10/16.
 * Code one more line :)
 */
public class Leet8 {
    public int myAtoi(String str) {
        char[] charArray = str.toCharArray();
        int noLeadingSpacePos = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                noLeadingSpacePos = i;
                break;
            }
        }
        long num = 0;
        int sign = -1;
        boolean numBegins = false;
        for (int i = noLeadingSpacePos; i < charArray.length; i++) {
            if (!numBegins && charArray[i] == '-' && sign == -1) {
                sign = 1;
            } else if (!numBegins && charArray[i] == '+' && sign == -1) {
                sign = 0;
            } else if ('0' <= charArray[i] && charArray[i] <= '9') {
                num = 10 * num + charArray[i] - '0';
                numBegins = true;
                if (num > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }
        if (num == (long) Integer.MAX_VALUE + 1 && sign == 1) return - (int) num;
        if (num == 0) return 0;
        if (sign == 1) num = -num;
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }
}
