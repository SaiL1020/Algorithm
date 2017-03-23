import java.util.Scanner;
/**
 * Created by sail on 8/21/16.
 * Code one more line :)
 */
public class CF706A {
    final double eps = 1e-8;
    public static void main(String[] args) {
        new CF706A().run();
    }

    public void run() {
        int xx, yy, n, x, y, v;
        double time, ans = Double.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        xx = sc.nextInt();
        yy = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            v = sc.nextInt();
            time = Math.sqrt(pow2(x - xx) + pow2(y - yy)) / v;
            if (ans - time > eps || time == 0)
                ans = time;
        }
        System.out.println(ans);
    }

    public double pow2(int x) {
        return x * x * 1.0;
    }
}
