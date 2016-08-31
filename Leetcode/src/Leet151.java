/**
 * Created by sail on 6/14/16.
 * Code one more line :)
 */
public class Leet151 {
    public String reverseWords(String s) {
        String[] words = s.split("\\s");
        StringBuilder sbd = new StringBuilder();
        int last = 0;
        while(last < words.length && words[last].equals("")) last++;
        System.out.println(last);
        for (int i = words.length - 1; i >= last; i--) {
            if (words[i].equals("")) continue;
            sbd.append(words[i]);
            if (i != last) sbd.append(" ");
        }
        return sbd.toString();
    }
}
