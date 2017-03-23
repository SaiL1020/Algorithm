/**
 * Created by sail on 11/10/16.
 * circularArrayLoop
 */
public class Leet457 {
    public boolean circularArrayLoop(int[] n) {
        int len = n.length;
        for (int i = 0; i < len; i++) {
            if (n[i] == 0) continue;
//            System.out.println("===" + i);
            int s = i;
            int f = getIndex(n, s);
            while (n[i] * n[f] > 0 && n[i] * n[getIndex(n, f)] > 0) {
                if (s == f) {
                    // one element loop
//                    System.out.println("hehe");
                    if (s == getIndex(n, s)) break;
                    return true;
                }
                s = getIndex(n, s);
                f = getIndex(n, getIndex(n, f));
//                System.out.println(s + " " + f);
            }
            s = i;
            while (s != f) {
                int ts = s;
                s = getIndex(n, s);
                n[ts] = 0;
            }
//            System.out.println(i);
        }
        
        return false;
    }
    private int getIndex(int[] n, int i) {
        return ((i + n[i]) % n.length + n.length) % n.length;
    }

    private void run() {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        System.out.println(circularArrayLoop(nums));
    }
    public static void main(String[] args) {
        new Leet457().run();
    }
}
