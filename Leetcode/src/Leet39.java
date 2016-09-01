import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sail on 9/1/16.
 * Code one more line :)
 */
public class Leet39 {
    int T;
    List<Integer> add;
    List<List<Integer>> ans;
    int[] vis;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        T = target;
        add = new LinkedList<>();
        ans = new LinkedList<>();
        vis = new int[candidates.length];
        solve(0, 0, candidates);

        for (List<Integer> l : ans) {
            for (int k : l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        return ans;
    }

//    public void solve(int cur, int tot, int[] candidates) {
//        if (cur == candidates.length && tot != T) return;
//        if (tot == T) {
//            ans.add(new LinkedList<>(add));
//            return;
//        } else if (tot < T) {
//            add.add(candidates[cur]);
//            solve(cur, tot + candidates[cur], candidates);
//            add.remove(add.size() - 1);
//            solve(cur + 1, tot, candidates);
//        }
//    }

    public void solve(int cur, int tot, int[] candidates) {
        if (tot == T) {
            ans.add(new LinkedList<>(add));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (tot + candidates[i] <= T) {
                add.add(candidates[i]);
                solve(i, tot + candidates[i], candidates);
                add.remove(add.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        new Leet39().run();
    }
    public void run() {
        combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
