import java.util.Scanner;

/**
 * Created by sail on 10/1/16.
 * Code one more line :)
 */
public class CF722A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int format = sc.nextInt(); sc.nextLine();
        String[] line = sc.nextLine().split(":");
        String hh = line[0], mm = line[1];
        if (format == 12) {
            if (hh.equals("00")) hh = "01";
            else if (hh.compareTo("12") > 0) hh = "0" + hh.charAt(1);
        } else {
            if (hh.compareTo("23") > 0) hh = "1" + hh.charAt(1);
        }
        if (mm.compareTo("59") > 0) mm = "0" + mm.charAt(1);
        System.out.println(hh + ":" + mm);
    }
}
