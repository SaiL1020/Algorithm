/**
 * Created by sail on 9/6/16.
 * Code one more line :)
 */
public class Leet190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans |= ((n >> i) & 0x1) << (31 - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(new Leet190().reverseBits(n));
    }
}
