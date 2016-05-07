/**
 * Created by sail on 5/6/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import lib.*;

public class Leet104Test {
    @Test(timeout=2000)
    public void test1() {
        TreeNode root = new TreeNode().buildTree(new Object[]{1,2,3,null,4});
        assertEquals(3, new Leet104().maxDepth(root));
    }

    @Test(timeout=2000)
    public void test0() {
        TreeNode root = new TreeNode().buildTree(new Object[]{1,2,3});
        assertEquals(2, new Leet104().maxDepth(root));
    }

}
