/**
 * Created by sail on 6/2/16.
 * Code one more line :)
 */
import java.util.*;
public class Leet51 {
    private int[] map;
    private int N;
    private List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        map = new int[n + 1];
        N = n;

        queen(1);

        return result;
    }

    public void queen(int row) {
        if (row == N + 1) {
            print();
            return ;
        }
        for (int j = 1; j <= N; j++) {
            if (check(row, j)) {
                map[row] = j;
                queen(row + 1);
            }
        }
    }

    public boolean check(int row, int col) {
        for (int i = 1; i < row; i++)
            if (map[i] == col || Math.abs(map[i] - col) == row - i)
                return false;
        return true;
    }

    public void print() {
        char[] line = new char[N];
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                line[j - 1] = map[i] == j ? 'Q' : '.';
            }
            //System.out.println(line);
            list.add(String.valueOf(line));
        }
        result.add(list);
    }
}
