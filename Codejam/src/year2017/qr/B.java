package year2017.qr;

import java.io.*;

/**
 * author:      SaiL1020
 * time:        4/7/17 6:58 PM
 * project:     Algorithm
 */
public class B {
    public static void main(String[] args) throws Exception{
        File input = new File("B-large.in");
        File output = new File("B-large.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String line = br.readLine();
            bw.write("Case #" + i + ": " + (solve(line)));
            bw.newLine();
        }
        bw.flush();
    }

    private static String solve(String str) {
        if (str.equals("0")) return "";
        char[] s = str.toCharArray();
        int n = s.length;
        int i = 1;
        while (i < n && s[i - 1] <= s[i]) i++;
        if (i == n) return str;
        //System.out.println(i);
        return solve(minusOne(str.substring(0, i - 1), ((char)(s[i - 1] - 1)))) + n9(n - i);
    }

    private static String n9(int n) {
        StringBuilder sbd = new StringBuilder();
        while (n-- > 0) sbd.append("9");
        return sbd.toString();
    }

    private static String minusOne(String str, char c) {
        //System.out.println(str + c);
        if (str.equals("") || c > '0') return str + c;

        StringBuilder sbd = new StringBuilder("9");
        int i = str.length() - 1;
        while (str.charAt(i) == '0') {
            sbd.append("9");
            --i;
        }
        if (i == 0 && str.charAt(0) == '1') return sbd.toString();
        sbd.insert(0, (char)(str.charAt(i) - 1));
        sbd.insert(0, str.substring(0, i));
        return sbd.toString();
    }
}
