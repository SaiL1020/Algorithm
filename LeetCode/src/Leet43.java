/**
 * Created by sail on 5/22/16.
 * Code one more line :)
 */
public class Leet43 {
    public String multiply(String num1, String num2) {
        if (checkZero(num1) || checkZero(num2)) return "0";
        String pre = null, now;
        for (int i = num2.length() - 1; i >= 0; i--) {
            now = add(num1, num2.charAt(i) - '0');
            if (i != num2.length() - 1)
                pre = shiftAdd(now, pre, num2.length() - i - 1);
            else
                pre = now;
//            System.out.println(now);
//            System.out.println(pre);
        }
        return pre;
    }

    public boolean checkZero(String num) {
        return (num.length() == 1 && num.charAt(0) == '0');
    }
    public String add(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int now = (num.charAt(i) - '0') * k + carry;

            sb.append(now % 10);
//            System.out.println(sb.toString());
            carry = now / 10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public String shiftAdd(String num1, String num2, int k) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num2.length() - 1, j = num1.length() - 1;
        while (i >= 0) {
            if (num2.length() - i <= k) {
                sb.append(num2.charAt(i) - '0');
            } else {

                int now = num2.charAt(i) - '0' + carry;
                if (j >= 0) {
                    now += +num1.charAt(j) - '0';
                    --j;
                }
                sb.append(now % 10);
                carry = now / 10;
            }
            --i;
        }
        while (j >= 0) {
            int now = num1.charAt(j) + carry - '0';
            sb.append(now % 10);
            carry = now / 10;
            --j;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
