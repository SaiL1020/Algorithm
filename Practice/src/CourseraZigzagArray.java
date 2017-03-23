import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by sail on 10/10/16.
 * Zigzag Array
 */
public class CourseraZigzagArray {
//    public class comp implements Comparator<Integer> {
//        public int compare(Integer o1, Integer o2) {
//            return o2 - o1;
//        }
//    }
    public int[] zigzagArray(int[] nums) {
        Queue<Integer> maxheap = new PriorityQueue<>((x,y) -> y-x);
                //new comp());
        for (int k : nums) maxheap.add(k); // descending

        Queue<Integer> minheap = new PriorityQueue<>();
        for (int k : nums) minheap.add(k);
        int n = nums.length, i = 0;
        int[] ans = new int[n];
        while (i < n) {
            ans[i++] = maxheap.poll();
            if (i == n) break;
            ans[i++] = minheap.poll();
        }
        return ans;
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
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] ans = zigzagArray(nums);
        for (int k : ans) out.print(k + " ");
        out.println();
        out.close();
    }
    public static void main(String[] args) {
        new CourseraZigzagArray().run();
    }
}
