package amazon;

/**
 * Created by sail on 11/13/16.
 * Code one more line :)
 */
public class Digits {
    public static int countDigits(int num) {
        int count = 0;
        int originalNum = num;
        while (num != 0) {
            num = num / 10;
            count ++;
        }
        return (originalNum % count);
    }

    public static void main(String[] args) {
        System.out.println(countDigits(122));
    }
}
