import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by sail on 5/24/16.
 * Code one more line :)
 */
public class Leet347Test {
    @Test(timeout=2000)
    public void test0() {
        int[] nums = new int[]{5,1,2,2,4,4,3,3,3}; int k = 2;
        List<Integer> ans = Arrays.stream(new int[]{2,3}).boxed().collect(Collectors.toList());
        assertEquals(ans, new Leet347().topKFrequent(nums, k));
    }

}
