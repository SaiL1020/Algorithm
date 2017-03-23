import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by sail on 10/18/16.
 * num Decodings
 */
public class Leet91 {
    //"9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"
    int cnt;
    int[] vis;
    public int numDecodings(String s) {
        if (s== null || s.length() == 0 || s.charAt(0) == '0') return 0;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9')
                return 0;
        }
        cnt = 0;
        vis = new int[100000];
        Arrays.fill(vis, -1);
        dfs(s, 0);
        return cnt;
    }
    private void dfs(String s, int pos) {
        if (s.equals("")) {
            cnt++;
            return;
        }
        if (vis[pos] != -1) {
            cnt += vis[pos];
            return;
        }
        if (s.charAt(0) == '0') {
            vis[pos] = 0;
            return;
        }
        if (s.length() >= 2) {
            int cur = Integer.parseInt(s.substring(0, 2));
            int curSum = 0, pre;
            if (cur <= 26) {
                pre = cnt;
                dfs(s.substring(2), pos + 2);
                curSum += cnt - pre;
            }
            pre = cnt;
            dfs(s.substring(1), pos + 1);
            curSum += cnt - pre;
            vis[pos] = curSum;
        } else {
            cnt++;
        }
    }

    FastScanner in;
    PrintWriter out;

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public void run(){
        in = new FastScanner();
        out = new PrintWriter(System.out);
        String str;
        while (!(str = in.nextToken()).equals("")) {
            System.out.println(numDecodings(str));
        }
        out.close();
    }
    public static void main(String[] args) {
        new Leet91().run();
//        JButton testButton = new JButton("Test Button");
//        testButton.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent ae){
//            System.out.println("Click Detected by Anon Class");
//            }
//        });
//
//        testButton.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));
//
//        // Swing stuff
//        JFrame frame = new JFrame("Listener Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(testButton, BorderLayout.CENTER);
//        frame.pack();
//        frame.setVisible(true);
    }
}
