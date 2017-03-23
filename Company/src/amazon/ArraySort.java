package amazon;

import java.util.Arrays;

/**
 * Created by sail on 11/13/16.
 * sortArray
 */
public class ArraySort {
    public static int[] sortArray(int[] arr) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i + 1; j < len; j++) {
                if (max < arr[j]) {     // find max element
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,5,6,1,2,3,9,5,3};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
