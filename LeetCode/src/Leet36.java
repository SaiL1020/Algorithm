import java.util.Arrays;

/**
 * Created by sail on 9/6/16.
 * Code one more line :)
 */
public class Leet36 {
        char[][] bd;
        int[] pt = new int[]{1,1,1,4,1,7,4,1,4,4,4,7,7,1,7,4,7,7};
        public boolean isValidSudoku(char[][] board) {
            bd = board;
            for (int i = 0; i < board.length; i += 3) {
                for (int j = i / 3; j < board[0].length; j += 3) {
                    if (!check(i + j / 3, j, i + j / 3)) return false;
                }
            }
            return true;
        }
        public boolean check(int i, int j, int sq) {
            //System.out.println(i + " " + j + " " + sq);
            boolean[] vis = new boolean[10];
            //System.out.println(sq + " ");
            for (int k = 0; k < bd.length; k++) {
                if (bd[i][k] == '.') continue;
                int ch = bd[i][k] - '0';
                if (vis[ch]) return false;
                //System.out.println(i + " " + ch + " " + vis[ch]);
                vis[ch] = true;
            }
            //System.out.println(sq + " ");
            Arrays.fill(vis, false);
            for (int k = 0; k < bd[0].length; k++) {
                if (bd[k][j] == '.') continue;
                int ch = bd[k][j] - '0';
                if (vis[ch]) return false;

                vis[ch] = true;
            }
            Arrays.fill(vis, false);

            for (int k = pt[2*sq] - 1; k <= pt[2*sq] + 1; k++) {
                for (int l = pt[2*sq+1] - 1; l <= pt[2*sq+1] + 1; l++) {
                    if (bd[k][l] == '.') continue;
                    int ch = bd[k][l] - '0';
                    if (vis[ch]) return false;
                    vis[ch] = true;
                }
            }

            return true;
        }
}
