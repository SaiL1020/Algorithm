import java.util.Arrays;
import java.util.Random;

/**
 * Created by sail on 9/11/16.
 * Code one more line :)
 */
public class Leet384 {
    int[] origin;
    Random rand;
    public Leet384(int[] nums) {
        origin = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (origin == null) return null;
        int[] copy = Arrays.copyOf(origin, origin.length);
        for (int i = 0; i < origin.length; i++) {
            int index = rand.nextInt(origin.length);
            int tmp = copy[i];
            copy[i] = copy[index];
            copy[index] = tmp;
        }
        return copy;
    }
}
