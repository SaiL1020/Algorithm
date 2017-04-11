package amazon;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * author:      SaiL1020
 * time:        4/11/17 1:50 PM
 * project:     Algorithm
 */
public class MergeTwoArraysInPlaceTest {
    @Test
    public void mergeTest() {
        int[] a = {3,100,101};
        int[] b = {1,2};
        new MergeTwoArryasInPlace().mergeInPlace(a, b);

        assertArrayEquals(a, new int[]{1,2,3});
        assertArrayEquals(b, new int[]{100,101});
    }
}