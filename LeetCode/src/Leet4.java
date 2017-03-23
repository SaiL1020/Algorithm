/**
 * Created by sail on 12/14/16.
 * findMedianSortedArrays
 */
public class Leet4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);
        int min = 0, max = m, half = (m + n + 1) / 2, i = 0, j = 0, n1 = 0, n2 = 0;
        while (min <= max) {
            i = (min + max) / 2;
            j = half - i;
            if (j > 0 && i < m && A[i] < B[j - 1]) min = i + 1;
            else if (i > 0 && j < n && A[i - 1] > B[j]) max = i - 1;
            else {
                if (i == 0) n1 = B[j - 1];
                else if (j == 0) n1 = A[i - 1];
                else n1 = Math.max(A[i - 1], B[j - 1]);
                break;
            }
        }
        if ((m + n) % 2 == 1) return n1;
        if (i == m) n2 = B[j];
        else if (j == n) n2 = A[i];
        else n2 = Math.min(A[i], B[j]);
        return (n1 + n2) / 2.0;
    }
}
