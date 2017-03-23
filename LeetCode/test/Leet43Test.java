import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 5/22/16.
 * Leet43 Test
 */
public class Leet43Test {
    @Test(timeout=2000)
    public void test0() {
        String n1 = "102", n2 = "102";
        assertEquals("10404", new Leet43().multiply(n1, n2));
    }

    @Test(timeout=2000)
    public void test1() {
        String n1 = "12", n2 = "3";
        assertEquals("36", new Leet43().multiply(n1, n2));
    }

    @Test(timeout=2000)
    public void test2() {
        String n1 = "12", n2 = "30";
        assertEquals("360", new Leet43().multiply(n1, n2));
    }
    @Test(timeout=2000)
    public void test3() {
        String n1 = "102", n2 = "1001";
        assertEquals("102102", new Leet43().multiply(n1, n2));
    }
}

