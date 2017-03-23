import lib.TreeNode;

/**
 * Created by sail on 11/10/16.
 * max Depth
 */
public class Leet104 {
    public int maxDepth(TreeNode root) {
        int curDepth = 0;
        return dfs(root, curDepth);
    }

    public int dfs(TreeNode root, int curDepth) {
        if (root != null)
            curDepth = Math.max(dfs(root.left, curDepth + 1),
                    dfs(root.right, curDepth + 1));
        return curDepth;
    }
}
