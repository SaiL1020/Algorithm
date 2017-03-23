package weekly23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sail on 3/11/17.
 * Word Abbreviation
 */
public class Week23D {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> ans = new ArrayList<>();
        for (String str : dict) {
            int len = str.length();
            if (len <= 3) {
                ans.add(str);
                continue;
            }
            int k = 0;
            for (String str2 : dict) {
                if (str.length() == str2.length()
                        && str.charAt(len - 1) == str2.charAt(len - 1)) {
                    for (int j = 0; j < len; j++) {
                        if (str.charAt(j) != str2.charAt(j)) {
                            k = Math.max(k, j);
                            break;
                        }
                    }
                }
            }
            if (len - k <= 3) ans.add(str);
            else ans.add(str.substring(0, k + 1) +
                            String.valueOf(len - k - 2) +
                            str.charAt(len - 1));
        }
        return ans;
    }

    private void run() {
        String[] str = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        List<String> list = Arrays.asList(str);
        System.out.println(wordsAbbreviation(list));
    }
    public static void main(String[] args) {
        new Week23D().run();
    }

}
