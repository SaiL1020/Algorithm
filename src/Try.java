/**
 * Created by sail on 4/10/16.
 */
public class Try {
    public static void main (String[] args) {
        int n = 10, m = 50;
        int[][] dis = new int[n][n];
        int[][] edge = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = edge[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
}
