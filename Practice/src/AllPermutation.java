import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sail on 12/8/16.
 *
 * Find all permutation by swapping after sorting
 * swap a[i - 1] and a[j] where a[i] > a[j] > a[i - 1]
 * a[i] is the peak of the interval [i-1, i, i+1, i+2, ... , length - 1]
 */
public class AllPermutation {
    public List<String> getAllPermutation(String s) {
        List<String> ans = new LinkedList<>();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        int i, j;
        while (true) {
            ans.add(String.valueOf(ch));
            for (i = ch.length - 2; i >= 0; i--) {
                if (ch[i] < ch[i + 1]) {
                    break;
                }
            }
            if (i == -1) break;
            for (j = ch.length - 1; ; j--) {
                if (ch[j] > ch[i]) {
                    break;
                }
            }
            swap(ch, i, j);

            for (i++, j = ch.length - 1; i < j; i++, j--) {
                swap(ch, i, j);
            }
        }
        return ans;
    }
    private void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }

    public void run() {
        String str = "ABA";
        System.out.println(getAllPermutation(str));
    }
    public static void main(String[] args) {
        new AllPermutation().run();
    }
}
