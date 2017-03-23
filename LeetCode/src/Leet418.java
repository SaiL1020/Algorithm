/**
 * Created by sail on 12/14/16.
 * 418. Sentence Screen Fitting
 */
public class Leet418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0
                || rows == 0 || cols == 0) return 0;

        int[] len = new int[sentence.length];
        int k = 0;      // position in the sentence

        // check length of each word
        for (String str : sentence) {
            len[k] = str.length();
            if (len[k++] > cols) return 0;
        }

        int ans = 0;
        int n = sentence.length;
        k = 0;
        for (int i = 0; i < rows; i++) {
            if (k == 0) {
                if (i != 0) {
                    ans = rows / i * ans;
                    i = rows / i * i;
                    if (i == rows) break;
                }
            }
            for (int curCol = 0; curCol <= cols - len[k]; curCol++) {
                curCol += len[k++];
                if (k == n) {
                    k = 0;
                    ans++;
                }
            }
        }
        return ans;
    }
}
