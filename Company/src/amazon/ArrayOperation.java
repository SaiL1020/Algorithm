package amazon;

/**
 * Created by sail on 11/13/16.
 * replaceValues
 */
public class ArrayOperation {
    public static int[] replaceValues(int arr[]) {
        int i, j, len = arr.length;
        if (len % 2 == 0) {
            for (i = 0; i < len; i++)
                arr[i] = 0;
        }
        else {
            for (j = 0; j < len; j++)
                arr[j] = 1;
        }
        return arr;
    }
}
