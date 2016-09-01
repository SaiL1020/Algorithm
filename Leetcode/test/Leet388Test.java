import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 8/31/16.
 * Code one more line :)
 */
public class Leet388Test {
    @Test(timeout=2000)
    public void test0() {
        String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        assertEquals(20, new Leet388().lengthLongestPath(str));
    }
}
