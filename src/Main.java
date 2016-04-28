import java.io.*;
import java.util.*;

/**
 * Created by sail on 4/8/16.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        File input = new File("A-large.in");
        File output = new File("A-large.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("Case #" + i + ": " + (N == 0 ? "INSOMNIA" : solve(N)));
            bw.newLine();
        }
        bw.flush();
    }

    public static int solve(int N) {
        HashSet<Integer> digit = new HashSet<Integer>();
        int ret = 1;
        for (int i = 1; digit.size() != 10; i++) {
            int cur = N * i;
            ret = cur;
            while (cur != 0) {
                digit.add(cur % 10);
                cur /= 10;
            }
        }
        return ret;
    }
}
