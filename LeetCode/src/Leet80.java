import java.util.Scanner;

/**
 * Created by sail on 9/12/16.
 * Code one more line :)
 */
public class Leet80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }

    public void run() {
        String str;
        int[] nums;
        Scanner sc = new Scanner(System.in);
        while ( ! (str = sc.nextLine()).equals("")) {
            String[] part = str.split(" ");
            nums = new int[part.length];
            for (int i = 0; i < part.length; i++) {
                nums[i] = Integer.parseInt(part[i]);
            }
            int ans = removeDuplicates(nums);

            System.out.println("ans: " + ans);
            for (int i = 0; i < ans; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new Leet80().run();
    }
}
