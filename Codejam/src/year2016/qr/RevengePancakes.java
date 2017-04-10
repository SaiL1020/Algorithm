package year2016.qr;

import java.io.*;

/**
 * Created by sail on 4/9/16.
 * count the occurrence of "-+" + "+-"
 */
public class RevengePancakes {
    public static void main(String[] args) throws Exception{
        File input = new File("B-large-practice.in");
        File output = new File("B-large-practice.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            bw.write("Case #" + i + ": " + solve(str));
            bw.newLine();
        }
        bw.flush();
    }

    public static int solve(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1))
                cnt++;
        }
        if (str.charAt(str.length() - 1) == '-')
            cnt++;
        return cnt;
    }
}
