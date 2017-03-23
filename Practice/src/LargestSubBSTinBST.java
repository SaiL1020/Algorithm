import java.util.Scanner;

/**
 * Created by sail on 11/20/16.
 * Largest SubBST in BST
 */
class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }
    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode buildTree(Object[] list) {
        if(list.length == 0 || list[0] == null)
            return null;
        TreeNode[] queue = new TreeNode[list.length];
        int front = 0, rear = 0;
        TreeNode current = null;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                current = new TreeNode((Integer) list[i]);
            else
                current = null;
            queue[rear++] = current;

            if (rear == 1) continue;
            if (queue[front] == null) continue;
            if (i % 2 == 1)
                queue[front].left = current;
            else {
                queue[front].right = current;
                while (front < list.length - 1 && queue[++front] == null) ;
            }
        }
        return queue[0];
    }
}

public class LargestSubBSTinBST {
    int cnt, L, R;
    public int getCount(TreeNode root, int l, int r) {
        cnt = 0;
        L = l; R = r;
        getSize(root);
        return cnt;
    }

    private boolean getSize(TreeNode root) {
        if (root == null) return true;

        boolean leftIsBST = getSize(root.left);
        boolean rightIsBST = getSize(root.right);

        if (root.val < L || root.val > R) return false;
        if (leftIsBST && rightIsBST) {
            cnt++;
            return true;
        }
        return false;
    }

    private void run() {
        TreeNode root = new TreeNode().buildTree(new Object[]{25,19,37,12,22,29,null,4,null,null,23,30});
        while (true) {
            Scanner sc = new Scanner(System.in);
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(getCount(root, l, r));
        }
    }
    public static void main(String[] args) {
        new LargestSubBSTinBST().run();
    }
}
