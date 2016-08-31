/**
 * Created by sail on 8/27/16.
 * Code one more line :)
 */
public class Leet390 {
    int N;
    public int lastRemaining(int n) {
        N = n;
        return dfs(1, 0, 1, 2);
    }
    public int dfs(int cur, int tot, int dir, int step) {
        System.out.println(cur + " " + tot + " " + dir + " " + step);
        if (tot == N - 1) return cur;
        int curStep = 1;
        if (dir == 1) {
            while (cur + step <= N) {
                cur += step;
                curStep++;
            }
            if (curStep > (N - tot) / 2)
                cur -= step / 2;
            else
                cur += step / 2;
        }
        else {
            while (cur - step > 0) {
                cur -= step;
                curStep++;
            }
            if (curStep > (N - tot) / 2)
                cur += step / 2;
            else
                cur -= step / 2;
        }
        System.out.println(curStep);
        return dfs(cur, tot + curStep, 1 - dir, step * 2);
    }
}
