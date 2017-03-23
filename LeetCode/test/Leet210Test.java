import org.junit.Test;

/**
 * Created by sail on 6/14/16.
 * Code one more line :)
 */
public class Leet210Test {
    @Test(timeout=2000)
    public void test0() {
        int numCourses = 4;
        int[][] preq = new int[][]{/*{1,0},{2,0},{3,1},{0,3}*/};
        int[] ans = new Leet210().findOrder(numCourses, preq);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        System.out.println(new int[]{0,1}.equals(new Leet210().findOrder(numCourses, preq)));
    }
}
