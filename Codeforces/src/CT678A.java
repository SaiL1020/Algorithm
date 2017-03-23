import java.util.Scanner;

/**
 * Created by sail on 6/13/16.
 * Code one more line :)
 */
public class CT678A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ret = (n / k + 1) * k;
        System.out.println(ret);
    }
}
