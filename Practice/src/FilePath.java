/**
 * Created by sail on 11/21/16.
 * FilePath
 */
public class FilePath {
    String[] extension = {"jpeg", "png", "gif"};
    public int solution(String s) {
        String[] paths = s.split("\n");
        int sum = 0;
        int[] dp = new int[paths.length + 1];
        //dp[0] = 1;
        boolean sameDir = false;
        for (String path : paths) {
            System.out.println(path);
            String name = path.replace(" ", "");
            int depth = path.length() - name.length();
            dp[depth + 1] = dp[depth] + name.length() + 1;
            int dotPos = name.indexOf(".");
            if (dotPos != -1 && check(name.substring(dotPos + 1))) {
                if (!sameDir) {
                    sameDir = true;
                    sum += dp[depth];
                }
            } else {
                sameDir = false;
            }
        }
        return sum;
    }
    private boolean check(String s) {
        for (String t : extension)
            if (s.equals(t))
                return true;
        return false;
    }

    private void run() {
        String str = "dir\n subdir1\n  file1.jpeg\n  f.png\n  subsubdir1\n   d.png\n subdir2\n  subsubdir2\n   file2.gif";
        System.out.println(solution(str));
    }
    public static void main(String[] args) {
        new FilePath().run();
    }
}
