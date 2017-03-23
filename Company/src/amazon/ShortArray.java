package amazon;

import java.util.Arrays;

/**
 * Created by sail on 11/13/16.
 * Remove Element
 */
public class ShortArray {
    public static int[] removeElement(int[] arr, int index) {
        int i, j, len = arr.length;
        if (index < len) {
            for (i = index; i < len - 1; i++) {
                arr[i] = arr[i + 1];
            }
            int rarr[] = new int[len - 1];
            for (i = 0; i < len - 1; i++) {
                rarr[i] = arr[i];
            }
            return rarr;
        }
        else
            return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,5,6,1,2,3,9,5};
        System.out.println(Arrays.toString(removeElement(arr, 15)));
    }
}
