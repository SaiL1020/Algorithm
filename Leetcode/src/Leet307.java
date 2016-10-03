/**
 * Created by sail on 9/24/16.
 * Code one more line :)
 */
public class Leet307 {

    public void run() {
        int[] nums = new int[]{7,2,7,2,0};
        NumArray numArray = new NumArray(nums);

        numArray.update(4, 6);
        numArray.update(0, 2);
        numArray.update(0, 9);
        System.out.println(numArray.sumRange(4, 4));
        numArray.update(3, 8);
        System.out.println(numArray.sumRange(0, 4));
        numArray.update(4, 1);
        System.out.println(numArray.sumRange(0, 3));
        System.out.println(numArray.sumRange(0, 4));
        numArray.update(0, 4);
    }
    public static void main(String[] args) {
        new Leet307().run();
    }
}

class NumArray {
    final int maxn = 222222;
    int[] sum = new int[maxn << 2];
    int[] num;
    int n, k;
    public NumArray(int[] nums) {
        num = nums;
        n = num.length;
        k = 0;
        build(0, n - 1, 1);
    }

    void pushUP(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }
    void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = num[k++];
            return;
        }
        int m = (l + r) >> 1;
        build(l, m, rt << 1);
        build(m + 1, r, rt << 1 | 1);
        pushUP(rt);
    }
    void updateLR(int p, int val, int l, int r, int rt) {
        if (l == r) {
            sum[rt] += val;
            return;
        }
        int m = (l + r) >> 1;
        if (p <= m) updateLR(p, val, l, m, rt << 1);
        else updateLR(p, val, m + 1, r, rt << 1 | 1);
        pushUP(rt);
    }
    int query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int m = (l + r) >> 1;
        int ret = 0;
        if (L <= m) ret += query(L, R, l, m, rt << 1);
        if (R > m) ret += query(L, R, m + 1, r, rt << 1 | 1);
        return ret;
    }

    void update(int i, int val) {

        updateLR(i, val - num[i], 0, n - 1, 1);
        num[i] = val;
    }

    public int sumRange(int i, int j) {
        return query(i, j, 0, n - 1, 1);
    }
}
