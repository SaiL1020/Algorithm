import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 8/27/16.
 * Code one more line :)
 */
public class Leet390Test {
    @Test(timeout=2000)
    public void test0() {
        int n = 9;
        assertEquals(6, new Leet390().lastRemaining(n));
    }
    @Test(timeout=2000)
    public void test1() {
        int n = 8;
        assertEquals(6, new Leet390().lastRemaining(n));
    }
    @Test(timeout=2000)
    public void test2() {
        int n = 10;
        assertEquals(8, new Leet390().lastRemaining(n));
    }
    @Test(timeout=2000)
    public void test3() {
        int n = 1;
        assertEquals(1, new Leet390().lastRemaining(n));
    }
    @Test(timeout=2000)
    public void test4() {
        int n = 3;
        assertEquals(2, new Leet390().lastRemaining(n));
    }
}
