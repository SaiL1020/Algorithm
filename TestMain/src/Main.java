import java.util.Scanner;

/**
 * author:      SaiL1020
 * time:        3/29/17 5:33 PM
 * project:     Algorithm
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("")) {
            System.out.println(Integer.parseInt(line) % Integer.MIN_VALUE);
        }
    }
}
