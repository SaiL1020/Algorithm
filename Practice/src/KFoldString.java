import java.util.Scanner;

/**
 * Created by sail on 11/20/16.
 * get K-Fold String
 */
public class KFoldString {
    public String getKFoldString(String str, int k) {
        str = str.replace("-", "");
        str = str.toUpperCase();
        int len = str.length();
        int first = len % k;
        StringBuilder sbd = new StringBuilder();
        sbd.append(str.substring(0, first));
        for (int i = first; i < len; i += k) {
            sbd.append("-");
            sbd.append(str.substring(i, i + k));
        }
        if (sbd.charAt(0) == '-') {
            sbd.deleteCharAt(0);
        }
        return sbd.toString();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.nextLine()).equals("")) {
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(getKFoldString(str, k));
        }
    }
    public static void main(String[] args) {
        new KFoldString().run();
    }
}
