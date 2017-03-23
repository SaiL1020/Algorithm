package amazon;

import java.util.Arrays;

/**
 * Created by sail on 11/13/16.
 * sortArray
 */
public class Array {
    public static int[] sortArray(int[] arr) {
        int len = arr.length;
        int i, j, temp;
        for (i = 0; i <= len - 1; i++) {
            for (j = i + 1; j < len; j++) {
                if (arr[i] < arr[j]) {  // descending
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,5,6,1,2,3,9,5,3};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
