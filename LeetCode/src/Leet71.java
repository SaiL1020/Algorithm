/**
 * Created by sail on 9/3/16.
 * Code one more line :)
 */
public class Leet71 {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        String[] part = path.split("/");
        int bypass = 0;
        for (int i = part.length - 1; i >= 0; i--) {
            if (part[i].equals("..")) bypass++;
            else if (!part[i].isEmpty() && !part[i].equals(".")) {
                if (bypass > 0) {
                    bypass--;
                } else {
                    ans.insert(0, "/" + part[i]);
                }
            }
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
