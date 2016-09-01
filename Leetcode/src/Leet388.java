import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by sail on 8/31/16.
 * Code one more line :)
 * #### Much thanks to: https://www.hrwhisper.me/leetcode-contest-1-solution/
 */
public class Leet388 {
    public int lengthLongestPath(String input) {
        System.out.println("======" + input);
        int maxlen = 0;
        int[] pathlen = new int[1000];
        //input = input.replace("\n", " ");
        System.out.println("------" + input);
        for (String line: input.split("\\n")) {
            System.out.println(line);
            String name = line.replace("\t", "");
            System.out.println(name);
            int depth = (line.length() - name.length());
            System.out.println(depth);
            if (name.contains("."))
                maxlen = Math.max(maxlen, pathlen[depth] + name.length());
            else
                pathlen[depth + 1] = pathlen[depth] + name.length() + 1;
        }
        return maxlen;
    }
}
