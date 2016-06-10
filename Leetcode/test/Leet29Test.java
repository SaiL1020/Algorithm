import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 6/10/16.
 * Code one more line :)
 */
public class Leet29Test {
    @Test(timeout=2000)
    public void test0() {
        int n1 = 2147483647, n2 = 2;
        assertEquals(1073741823, new Leet29().divide(n1, n2));
    }

    @Test(timeout=2000)
    public void test2() {
        int n1 = -2147483648, n2 = -1;
        assertEquals(2147483647, new Leet29().divide(n1, n2));
    }
}
