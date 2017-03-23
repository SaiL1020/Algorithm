import java.util.Arrays;

/**
 * Created by sail on 10/16/16.
 * CourseraRoyalName
 */
public class CourseraRoyalName {
    Object[] map = new Object[]{'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000};
    class Name {
        String name;
        int num;
        Name(String s, int n) {
            name = s;
            num = n;
        }
    }
    public int romanToInt(String s) {
        int len = s.length();
        int ans = getNum(s.charAt(len - 1));
        int pre = getNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getNum(s.charAt(i));
            if (cur > pre) ans -= pre;
            else ans += pre;
            pre = cur;
        }
        return ans;
    }
    public int getNum(char ch) {
        for (int i = 0; i < map.length; i += 2) {
            if ((char)map[i] == ch)
                return (int)map[i + 1];
        }
        return -1;
    }
    public String[] getSortedList(String[] names) {
        int n = names.length;
        if (n < 2) return names;

        Name[] nameWithNum = new Name[n];
        for (int i = 0; i < n; i++) {
            nameWithNum[i] = new Name(names[i].split(" ")[0],
                            romanToInt(names[i].split(" ")[1]));
        }
        Arrays.sort(nameWithNum, (o1, o2) ->
                    o1.name.equals(o2.name) ?
                        o1.num - o2.num : o1.name.compareTo(o2.name));
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nameWithNum[i].name;
        }
        return ans;
    }

    private void run() {
        String[] names = new String[]{"a I", "a II", "b V", "c V", "b IV"};
        String[] sortedNames = getSortedList(names);
        for (String s : sortedNames)
            System.out.println(s);
    }
    public static void main(String[] args) {
        new CourseraRoyalName().run();
    }
}
