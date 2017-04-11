package amazon;

/**
 * author:      SaiL1020
 * time:        4/11/17 1:42 PM
 * project:     Algorithm
 */
public class MergeTwoArryasInPlace {
    public void mergeInPlace(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        for (int i = n - 1; i >= 0; i--) {
            int last = a[m - 1];
            int j;
            /* Find the smallest element greater than ar2[i]. Move all
                elements one position ahead till the smallest greater
                element is not found */
            for (j = m - 2; j >= 0 && a[j] > b[i]; j--) {
                a[j + 1] = a[j];
            }
            // if there was a greater element
            if (j != m - 2 || last > b[i]) {
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }
}
