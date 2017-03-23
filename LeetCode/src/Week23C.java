import lib.TreeNode;

/**
 * Created by sail on 3/11/17.
 * Construct Binary Tree from String
 */
public class Week23C {
    public TreeNode str2tree(String s) {
        return dfs(s);
    }
    private TreeNode dfs(String s) {
        //System.out.println(s);
        if (s == null || s.length() == 0) return null;
        int[] ret = getNextVal(s);
        int rootVal = ret[0], shift = ret[1];
        TreeNode root = new TreeNode(rootVal);
        int cut = getCut(s.substring(shift));
        if (cut == 0) {
            return root;
        }
        //System.out.println("== " + cut);
        root.left = dfs(s.substring(shift + 1, shift + cut));
        root.right = cut + shift + 1 >= s.length() ? null : dfs(s.substring(cut + shift + 2, s.length() - 1));
        return root;
    }
    private int[] getNextVal(String s) {
        //System.out.println("---- " + s);
        int i = 0;
        StringBuilder sbd = new StringBuilder();
        while (i < s.length() && s.charAt(i) != '(') {
            sbd.append(s.charAt(i++));
        }
        return new int[]{Integer.parseInt(sbd.toString()), i};
    }
    private int getCut(String s) {
        //if (s.length() == 0) return 0;
        int left = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') left--;
            else if (s.charAt(i) == '(') left++;
            if (left == 0) return i;
        }
        return 0;
    }

    private void run() {
        String s = "-4(2(-3)(1))(6(5))";
        System.out.println(str2tree(s));
    }
    public static void main(String[] args) {
        new Week23C().run();
    }

}
