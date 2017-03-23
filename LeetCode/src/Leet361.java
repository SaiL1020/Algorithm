/**
 * Created by sail on 12/14/16.
 * Destroy Enemies with walls
 */
public class Leet361 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        int rowHit = 0, ans = 0;
        int[] colHit = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHit = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++)
                        if (grid[i][k] == 'E')
                            rowHit++;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHit[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++)
                        if (grid[k][j] == 'E')
                            colHit[j]++;
                }
                //System.out.println(i + " " + j + " " + rowHit + " " + colHit[j]);
                if (grid[i][j] == '0' && ans < rowHit + colHit[j]) {
                    ans = rowHit + colHit[j];
                }
            }
        }
        return ans;
    }
}
