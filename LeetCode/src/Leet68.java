import java.util.LinkedList;
import java.util.List;

/**
 * Created by sail on 9/17/16.
 * Code one more line :)
 */
public class Leet68 {
    public static void main(String[] args) {
        new Leet68().run();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        boolean newLine = true;
        StringBuilder sbd = new StringBuilder();
        int curLen = 0, st = 0;
        for (int i = 0; i <= words.length; i++) {
            if (i < words.length) {
                curLen += words[i].length();
                if (!newLine) curLen++;
            }
            if (curLen <= maxWidth && i != words.length) {
                sbd.append(words[i]);
                newLine = false;
            } else {
                newLine = true;

                int space = maxWidth - sbd.length();
                if (i != words.length) {
                    if (i > st + 1) {
                        int insertPos = sbd.length();
                        for (int j = i - 1; j > st; j--) {
                            insertPos -= words[j].length();
                            int tot = j - st;
                            int curSpace = space / tot;
                            space -= curSpace;
                            sbd.insert(insertPos, generateKSpace(curSpace));
                        }
                    } else {
                        int curSpace = maxWidth - sbd.length();
                        sbd.append(generateKSpace(curSpace));
                    }
                } else {
                    int insertPos = sbd.length();
                    for (int j = i - 1; j > st; j--) {
                        insertPos -= words[j].length();
                        String chSpace = " ";
                        sbd.insert(insertPos, chSpace);
                    }
                    int curSpace = maxWidth - sbd.length();
                    sbd.append(generateKSpace(curSpace));
                }

                ans.add(sbd.toString());
                if (i == words.length) break;
                sbd.setLength(0);
                curLen = 0;
                st = i--;
            }
        }
        return ans;
    }
    public String generateKSpace(int k) {
        String chSpace = "";
        while (k-- > 0) chSpace += " ";
        return chSpace;
    }

    public void run() {
        String[] words = new String[]{"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};//, "an", "examp", "of", "text", "justification."};
        int L = 30;
        List<String> ans = fullJustify(words, L);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
