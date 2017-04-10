package year2017.qr;

import java.io.*;

/**
 * author:      SaiL1020
 * time:        4/7/17 6:58 PM
 * project:     Algorithm
 */
public class A {
    public static void main(String[] args) throws Exception{
        File input = new File("A-large.in");
        File output = new File("A-large.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] line = br.readLine().split(" ");
            String str = line[0];
            int K = Integer.parseInt(line[1]);
            int cnt = solve(str.toCharArray(), K);
            bw.write("Case #" + i + ": " + (cnt == -1 ? "IMPOSSIBLE" : cnt));
            bw.newLine();
        }
        bw.flush();
    }

    public static int solve(char[] s, int K) {
        int cnt = 0, i = 0, j = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] == '+') i++;
            if (i == n) break;
            if (i + K > n) {
                cnt = -1;
                break;
            }
            for (j = i + 1; j < i + K; j++) {
                s[j] = (s[j] == '+') ? '-' : '+';
            }
            i++;
            cnt++;
        }
        return cnt;
    }
}
