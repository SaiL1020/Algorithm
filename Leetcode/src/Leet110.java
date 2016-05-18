/**
 * Created by sail on 5/18/16.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import lib.*;

public class Leet110 {
    boolean ret = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ret;
    }
    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftChild = dfs(root.left);
        int rightChild = dfs(root.right);
        if(Math.abs(leftChild - rightChild) > 1)
            ret = false;
        // Depth of subtree :)
        return Math.max(leftChild, rightChild) + 1;
    }
}
