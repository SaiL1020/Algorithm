/**
 * Created by sail on 10/29/16.
 * Code one more line :)
 */

import java.util.*;
import java.io.*;

public class Leet149 {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int overlap = 0;
            int cnt = 0;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();  // <x0, <y0, cnt>>
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcdXY = gcd(x, y);
                if (gcdXY != 0) {
                    x /= gcdXY;
                    y /= gcdXY;
                }
                Map<Integer, Integer> yToCnt = map.getOrDefault(x, new HashMap<>());
                yToCnt.put(y, yToCnt.getOrDefault(y, 0) + 1);
                map.put(x, yToCnt);
                cnt = Math.max(cnt, yToCnt.get(y));
            }
            ans = Math.max(overlap + cnt + 1, ans);
        }
        return ans;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}