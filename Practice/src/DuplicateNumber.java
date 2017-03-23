import java.util.Scanner;

/**
 * Created by sail on 11/21/16.
 * DuplicateNumber
 */
public class DuplicateNumber {
    public int solution(int x) {
        int max = Integer.MIN_VALUE;
        StringBuilder sbd = new StringBuilder(String.valueOf(x));
        for (int i = 1; i < sbd.length(); i++) {
            if (sbd.charAt(i - 1) == sbd.charAt(i)) {
                StringBuilder b = new StringBuilder(sbd);
                b.deleteCharAt(i);
                int a = Integer.parseInt(b.toString());
                if (a > max) max = a;
            }
        }
        return max;
    }
    public int roundUp(int x) {
        int max = Integer.MIN_VALUE;
        StringBuilder sbd = new StringBuilder(String.valueOf(x));
        for (int i = 1; i < sbd.length(); i++) {
            int a = sbd.charAt(i - 1) - '0';
            int b = sbd.charAt(i) - '0';
            int c = (int)Math.ceil((a + b) / 2.0);
            StringBuilder temp = new StringBuilder(sbd);
            temp.delete(i - 1, i + 1);
            temp.insert(i - 1, c);
            int tempNum = Integer.parseInt(temp.toString());
            if (tempNum > max) max = tempNum;
        }
        return max;
    }

    private void run() {
        int x;
        Scanner sc = new Scanner(System.in);
        while ((x = sc.nextInt()) != 0) {
            System.out.println(roundUp(x));
        }
    }
    public static void main(String[] args) {
        new DuplicateNumber().run();
    }
}
