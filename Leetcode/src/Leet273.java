import java.util.Scanner;

/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet273 {
    String[] One = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] Ten = new String[]{"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] Tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] Other = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuffer sbf = new StringBuffer();
        int bit = 0, cur, pre = 0;
        while (num != 0) {
            if (bit % 3 == 0) {
                cur = num % 100;
                num /= 100;

                System.out.println("= " + cur + " " + num);
                if (bit != 0) {
                    int index = -1;
                    if (pre  == 0 && bit / 3 > 1) {
                        index = sbf.indexOf(Other[bit / 3 - 1]);
                        if (index >= 0) {
                            sbf.delete(index, index + Other[bit / 3 - 1].length());
                        }
                    }
                    if (index < 0 && sbf.length() != 0) sbf.insert(0, " ");
                    sbf.insert(0, Other[bit / 3]);
                }
                pre = cur;
                bit += 2;
                if (cur == 0) continue;
                if (sbf.length() != 0) sbf.insert(0, " ");
                if (0 < cur && cur < 10) {
                    sbf.insert(0, One[cur]);
                } else if (10 < cur && cur < 20) {
                    sbf.insert(0, Ten[cur % 10]);
                } else if (cur % 10 == 0) {
                    sbf.insert(0, Tens[cur / 10]);
                } else {
                    sbf.insert(0, One[cur % 10]);
                    sbf.insert(0, Tens[cur / 10] + " ");
                }

            } else if (bit % 3 == 2) {
                cur = num % 10;
                num /= 10;
                pre = (pre == 0 && cur == 0) ? 0 : cur + 1;
                System.out.println("== " + cur + " " + num);
                if (cur != 0) {
                    if (sbf.length() != 0) sbf.insert(0, " ");
                    sbf.insert(0, "Hundred");
                    sbf.insert(0, One[cur] + " ");
                }
                bit++;
            }
        }
        return sbf.toString();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        while (num != 0) {
            num = sc.nextInt();
            System.out.println(numberToWords(num));
        }
    }
    public static void main(String[] args) {
        new Leet273().run();
    }
}
