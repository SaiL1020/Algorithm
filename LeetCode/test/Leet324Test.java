import org.junit.Test;

/**
 * Created by sail on 6/22/16.
 * Code one more line :)
 */
public class Leet324Test {
    @Test(timeout=2000)
    public void test0() {
        int[] nums = new int[]{1,1,1,4,5,6};
        new Leet324().wiggleSort(nums);
        System.out.println(new int[]{1,1,1,4,5,6}.equals(nums));
    }
}
