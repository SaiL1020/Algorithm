import java.util.*;

/**
 * Created by sail on 8/22/16.
 * Code one more line :)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String king = sc.nextLine();
        char c = king.charAt(0);
        char d = king.charAt(1);
        int ans = 0;
        if ((c == 'a' || c == 'h') && (d == '1' || d == '8'))
            ans = 3;
        else if (c == 'a' || c == 'h' || d == '1' || d == '8')
            ans = 5;
        else
            ans = 8;
        System.out.println(ans);
    }
}
