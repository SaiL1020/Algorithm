/**
 * Created by sail on 9/1/16.
 * Code one more line :)
 */
public class Leet52 {
    int N, cnt;
    int[] line;
    public int totalNQueens(int n) {
        N = n;
        cnt = 0;
        line = new int[N];
        solve(0);
        return cnt;
    }
    public void solve(int row) {
        if (row == N) {
            cnt++;
        }
        for (int j = 0; j < N; j++) {
            if (check(row, j)) {
                line[row] = j;
                solve(row + 1);
            }
        }
    }
    public boolean check(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (line[i] == c || r - i == Math.abs(c - line[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Leet52().run();
    }
    public void run() {
        System.out.println(totalNQueens(8));
    }
}
