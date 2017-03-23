import java.util.Arrays;

/**
 * Created by sail on 12/14/16.
 * find Radius
 */
public class Leet475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, ans = 0;
        for (int house : houses) {
            while (i < heaters.length - 1
                    && heaters[i + 1] + heaters[i] <= house * 2) {
                i++;
            }
            ans = Math.max(ans, Math.abs(heaters[i] - house));
        }
        return ans;
    }
}
