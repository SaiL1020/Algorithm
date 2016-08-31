import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 8/28/16.
 * Code one more line :)
 */
public class Leet386Test {
    @Test(timeout=2000)
    public void test0() {
        int n = 13;
        List<Integer> list = Arrays.asList(1,10,11,12,13,2,3,4,5,6,7,8,9);
        assertEquals(list, new Leet386().lexicalOrder(n));
    }
    @Test(timeout=2000)
    public void test1() {
        int n = 22;
        List<Integer> list = Arrays.asList(1,10,11,12,13,2,20,21,22,3,4,5,6,7,8,9);
        assertEquals(list, new Leet386().lexicalOrder(n));
    }
    @Test(timeout=2000)
    public void test2() {
        int n = 100;
        assertEquals(8, new Leet386().lexicalOrder(n));
    }
//    @Test(timeout=2000)
//    public void test3() {
//        int n = 1;
//        assertEquals(1, new Leet386().lexicalOrder(n));
//    }
//    @Test(timeout=2000)
//    public void test4() {
//        int n = 3;
//        assertEquals(2, new Leet386().lexicalOrder(n));
//    }
}
