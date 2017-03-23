import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sail on 9/10/16.
 * Code one more line :)
 */
public class Leet397 {
    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        init(100);
        if (map.containsKey(n)) return map.get(n);
        int cnt = 0;
        while (n > 100) {
            cnt++;
            if (n % 2 == 0) n /= 2;
            else n--;
            if (map.containsKey(n)) break;
        }
        return map.get(n) + cnt;
    }
    public void init(int m) {
        map.put(0, -1);
        for (int i = 1; i <= m; i++) {
            if (map.containsKey(i)) continue;
            int n = i, cnt = Math.min(map.get(i - 1), map.getOrDefault(i + 1, 100)) + 1;
            while (n <= Integer.MAX_VALUE / 2) {
                if (map.containsKey(n))
                    cnt = map.get(n);
                map.put(n, cnt);
                //System.out.println(n + " " + cnt);
                //if (n > m) break;
                n *= 2;
                cnt++;
            }
            //if (map.containsKey(m)) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            System.out.println(new Leet397().integerReplacement(k));
        }
    }
}
