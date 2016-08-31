import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 8/27/16.
 * Code one more line :)
 */
public class Leet389Test {
    @Test(timeout=2000)
    public void test0() {
        String s = "abcd", t = "abcde";
        assertEquals("e", new Leet389().findTheDifference(s,t));
    }
}
