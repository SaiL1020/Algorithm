import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 6/10/16.
 * Code one more line :)
 */
public class Leet8Test {
    @Test(timeout=2000)
    public void test0() {
        String[] n1 = {"2147483647", "+2", "-2147483648", "2147483648", "    -010", "1+0", "+0066", "3k2", "-3k2", "-06"};
        int[] n2 = {2147483647, 2, -2147483648, 2147483647, -10, 1, 66, 3, -3, -6};
        for (int i = 0; i < n1.length; i++) {
            assertEquals(n2[i], new Leet8().myAtoi(n1[i]));
        }
    }
}
