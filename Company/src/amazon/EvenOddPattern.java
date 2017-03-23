package amazon;

/**
 * Created by sail on 11/13/16.
 * Print Pattern
 */
public class EvenOddPattern {
    public static void printPattern(int num) {
        int i, print;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        }
        else {
            print = 1;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        }
    }
    public static void main(String[] args) {
        printPattern(6);
    }
}
