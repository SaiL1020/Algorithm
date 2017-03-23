package lib;

/**
 * Created by sail on 5/6/16.
 * TreeNode Class
 */
public class TreeNode {

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
