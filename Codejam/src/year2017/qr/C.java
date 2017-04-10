package year2017.qr;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * author:      SaiL1020
 * time:        4/7/17 10:14 PM
 * project:     Algorithm
 */
//class Int implements Comparable<Int> {
//    long l, r, w;
//    public Int(long a, long b) {
//        l = a; r = b; w = b - a + 1;
//    }
//    @Override
//    public int compareTo(Int o) {
//        return this.w == o.w ? Long.compare(this.l, o.l) : Long.compare(o.w, this.w);
//    }
//}

public class C {
    public static void main(String[] args) throws Exception{
        File input = new File("C-large-practice.in");
        File output = new File("C-large-practice.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] line = br.readLine().split(" ");
            long N = Long.parseLong(line[0]);
            long K = Long.parseLong(line[1]);
            long[] ans = solve(N, K);
            //System.out.println(ans[0] + " " + ans[1]);
            bw.write("Case #" + i + ": " + ans[0] + " " + ans[1]);
            bw.newLine();
        }
        bw.flush();
    }

    public static long[] solve(long N, long K) {
        TreeMap<Long, Long> map = new TreeMap<>();
        map.put(N, 1L);
        long P = 0;
        while (true) {
            Map.Entry<Long, Long> max = map.lastEntry();
            long C = max.getKey(), V = max.getValue();
            long X0 = C / 2;
            long X1 = (C - 1) / 2;
            P += V;
            if (P >= K) return new long[]{X0, X1};
            map.remove(C);
            map.put(X0, map.getOrDefault(X0, 0L) + V);
            map.put(X1, map.getOrDefault(X1, 0L) + V);
        }
    }
}
