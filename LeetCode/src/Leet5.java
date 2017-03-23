/**
 * Created by sail on 6/13/16.
 * Code one more line :)
 */
public class Leet5 {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int start = 0, end = 1, max = 1, shift;
        for (int i = 0; i < charArray.length; i++) {
            shift = 1;
            while(i - shift >= 0 && i + shift < charArray.length &&
                    charArray[i - shift] == charArray[i + shift]) {
                ++shift;
                System.out.println("YES");
            }
            if (2 * shift - 1 > max) {
                max = 2 * shift - 1;
                start = i - shift + 1;
                end = i + shift;
            }
        }
        for (int i = 0; i < charArray.length - 1; i++) {
            shift = 0;
            while(i - shift >= 0 && i + 1 + shift < charArray.length &&
                    charArray[i - shift] == charArray[i + 1 + shift])
                ++shift;
            if (2 * shift > max) {
                max = 2 * shift;
                start = i - shift + 1;
                end = i + 1 + shift;
            }
        }
        return s.substring(start, end);
    }
}
