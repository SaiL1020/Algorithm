import lib.TreeNode;
/**
 * author:      SaiL1020
 * time:        4/8/17 9:30 PM
 * project:     Algorithm
 */
public class Leet549 {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int upVal = 1, downVal = 1;
        if(root.left != null) {
            if (root.val + 1 == root.left.val) upVal = Math.max(upVal, 1 + left[0]);
            else if (root.val - 1 == root.left.val) downVal = Math.max(downVal, 1 + left[1]);
        }
        if(root.right != null) {
            if (root.val + 1 == root.right.val) upVal = Math.max(upVal, 1 + right[0]);
            else if (root.val - 1 == root.right.val) downVal = Math.max(downVal, 1 + right[1]);
        }
        max = Math.max(max, upVal + downVal - 1);
        return new int[]{upVal, downVal};
    }

    private void run() {
//        while (true) {
//            int n = new Scanner(System.in).nextInt();
//            System.out.println(nextGreaterElement(n));
//        }
        TreeNode root = new TreeNode().buildTree(new Object[]{1});
        System.out.println(longestConsecutive(root));
    }
    public static void main(String[] args) {
        new Leet549().run();
    }
}
