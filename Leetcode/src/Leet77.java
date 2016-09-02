import java.util.LinkedList;
import java.util.List;

/**
 * Created by sail on 9/1/16.
 * Code one more line :)
 */
public class Leet77 {
    List<List<Integer>> ans;
    List<Integer> com;
    int N, K;
    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        ans = new LinkedList<>();
        com = new LinkedList<>();
        solve(1);
        return ans;
    }
    public void solve(int cur) {
        if (com.size() == K) {
            ans.add(new LinkedList<>(com));
            return;
        }
        for (int i = cur; i <= N; i++) {
            com.add(i);
            solve(i + 1);
            com.remove(com.size() - 1);
        }
    }
    public static void main(String[] args) {
        new Leet77().run();
    }
    public void run() {
        print(combine(4,2));
    }
    public void print(List<List<Integer>> ans) {
        for (List<Integer> l : ans) {
            for (int k : l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
