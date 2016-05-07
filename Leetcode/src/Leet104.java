/**
Created by sail on 5/6/16.
 */

// Definition for a binary tree node.
import lib.TreeNode;

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
