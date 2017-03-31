import java.util.Arrays;

/**
 * author:      SaiL1020
 * time:        3/30/17 5:20 PM
 * project:     Algorithm
 */
public class Leet452 {
    class Point {
        int l, r;
    }
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int n = points.length;
        Point[] pt = new Point[n];
        int i = 0;
        for (int[] pair : points) {
            pt[i++] = new Point(){{l=pair[0];r=pair[1];}};
        }
        Arrays.sort(pt, (a, b)->(a.r==b.r ? a.l-b.l : a.r-b.r));

        int ans = 0;
        int cur = 0;
        while (cur < n) {
            int arrow = pt[cur].r;
            int nxt = cur + 1;
            while (nxt < n && pt[nxt].l <= arrow) {
                nxt++;
            }
            cur = nxt;
            ans++;
        }
        return ans;
    }
}
