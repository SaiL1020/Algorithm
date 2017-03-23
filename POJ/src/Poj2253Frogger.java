import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sail on 3/9/16.
 * Union Set & Binary Search
 */
public class Poj2253Frogger {
    int n;
    int[] x, y;
    int[] fa;
    double[][] dis;
    final double eps = 1e-8;
    final int N = 300;
    public static void main(String[] args) {
        try {
            new Poj2253Frogger().func();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void func() throws IOException {
        Scanner sc = new Scanner(System.in);
        int scenario = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) break;
            x = new int[N];
            y = new int[N];
            dis = new double[N][N];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                dis[i] = new double[N];
                for (int j = i + 1; j < n; j++) {
                    dis[i][j] = calcDistance(i, j);
                }
            }
            double left = 0, right = calcDistance(0, 1);
            while (right - left > eps) {
                double mid = (left + right) / 2.0;
                if (unionSetSearch(mid)) right = mid;
                else left = mid;
            }
            System.out.println("Scenario #" + (++scenario));
            System.out.println("Frog Distance = " +
                    String.format("%.3f", Math.round(right * 1000.0) / 1000.0));
            System.out.println();
        }
    }

    public double calcDistance(int i, int j) {
        return Math.sqrt((double)((x[i] - x[j]) * (x[i] - x[j]) +
                (y[i] - y[j]) * (y[i] - y[j])));
    }

    public boolean unionSetSearch(double k) {
        init();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dis[i][j] - k < eps) {
                    unionSet(i, j);
                }
            }
        }
        return getFather(0) == getFather(1);
    }

    public void init() {
        fa = new int[N];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public void unionSet(int x, int y) {
        x = getFather(x);
        y = getFather(y);
        if (x != y) fa[x] = y;
    }

    public int getFather(int v) {
        if (fa[v] == v) return v;
        return fa[v] = getFather(fa[v]);
    }
}
