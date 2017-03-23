import lib.TreeNode;

/**
 * Created by sail on 9/26/16.
 * buildTree preorder inorder
 */
public class Leet105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] in, int prest, int preed, int inst, int ined) {
        if (prest > preed || inst > ined) return null;
        TreeNode root = new TreeNode(pre[prest]);
        for (int i = prest; ; i++) {
            if (in[i] == pre[prest]) {
                root.left = build(pre, in, prest + 1, prest + i - inst, inst, i - 1);
                root.right = build(pre, in, prest + i - inst + 1, preed, i + 1, ined);
                break;
            }
        }
        return root;
    }
}
