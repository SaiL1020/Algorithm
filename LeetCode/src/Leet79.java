/**
 * Created by sail on 9/1/16.
 * Code one more line :)
 */
public class Leet79 {
    int[] dir = {0,1,1,0,0,-1,-1,0};
    int[][] vis;
    char[][] bd;
    char[] wd;
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        bd = board;
        wd = word.toCharArray();
        vis = new int[bd.length][bd[0].length];
        for (int i = 0; i < bd.length; i++) {
            for (int j = 0; j < bd[0].length; j++) {
                if (bd[i][j] == wd[0]) {
                    vis[i][j] = 1;
                    if (solve(i, j, 1)) return true;
                    vis[i][j] = 0;
                }
            }
        }
        return false;
    }
    public boolean solve(int i, int j, int cur) {
        if (cur == wd.length) return true;
        if (cur > wd.length) return false;

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[2*k], nj = j + dir[2*k+1];
            if (check(ni, nj) && bd[ni][nj] == wd[cur]) {
                vis[ni][nj] = 1;
                if (solve(ni, nj, cur + 1)) return true;
                vis[ni][nj] = 0;
            }
        }
        return false;
    }
    public boolean check(int i, int j) {
        return ! (i < 0
                || j < 0
                || i >= bd.length
                || j >= bd[0].length
                || vis[i][j] == 1
        );
    }
}
