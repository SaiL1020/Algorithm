package amazon;

import java.util.Arrays;

/**
 * Created by sail on 11/13/16.
 * Reverse Array
 */
public class SortArray {
    public static int[] reverseArray(int[] arr) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for (i = 0; i < originalLen / 2; i++) {
            temp = arr[len - 1];
            arr[len - 1] = arr[i];
            arr[i] = temp;
            len -= 1;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,5,6,1,2,3,9,5};
        System.out.println(Arrays.toString(reverseArray(arr)));
    }
}
