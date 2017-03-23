import java.util.ArrayList;
import java.util.List;
/**
 * Created by sail on 8/28/16.
 * Code one more line :)
 */
public class Leet386 {
    int N;
    List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        N = n;
        list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i > n) break;
            list.add(i);
            gen(i);
        }
        return list;
    }

    public void gen(int first) {
        for (int i = 0; i < 10; i++) {
            int cur = first * 10 + i;
            if (cur <= N) {
                list.add(cur);
                gen(cur);
            } else {
                break;
            }
        }
    }
}
