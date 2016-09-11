import java.util.*;

/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        final double esp = 1e-8;
        Map<String, Integer> map = new HashMap<>();
        int sz = 0;
        for (String[] equation: equations) {
            for (String str : equation) {
                if (!map.containsKey(str)) {
                    map.put(str, sz++);
                }
            }
        }
        double[][] dis = new double[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int j = i; j < sz; j++) {
                dis[i][j] = dis[j][i] = -1.0;
            }
        }
        for (int k = 0; k < equations.length; k++) {
            int i = map.get(equations[k][0]);
            int j = map.get(equations[k][1]);
            dis[i][j] = values[k];
            if (values[k] != 0) dis[j][i] = 1.0 / values[k];
        }

        for (int k = 0; k < sz; k++) {
            for (int i = 0; i < sz; i++) {
                for (int j = i; j < sz; j++) {
                    if (Math.abs(dis[i][k] + 1.0) > esp &&
                            Math.abs(dis[k][j] + 1.0) > esp) {
                        if (Math.abs(dis[k][j]) > esp) {
                            dis[i][j] = dis[i][k] * dis[k][j];
                            if (Math.abs(dis[i][j]) > esp) {
                                dis[j][i] = 1.0 / dis[i][j];
                            }
                        }
                    }
                }
            }
        }

        double[] ans = new double[query.length];
        for (int k = 0; k < query.length; k++) {
            int i = map.getOrDefault(query[k][0], -1);
            int j = map.getOrDefault(query[k][1], -1);
            if (i == -1 || j == -1) {
                ans[k] = -1.0;
                continue;
            }
            ans[k] = dis[i][j];
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] equations = new String[][]{{"a","b"},{"b","c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] query = new String[][]{{"a","c"},{"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };

        for (double ans : new Leet399().calcEquation(equations,values,query)) {
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
