import lib.TreeNode;

/**
 * Created by sail on 5/16/16.
 *
 * Convert sorted array to binary search tree (BST)
 */
public class Leet108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode[] queue = new TreeNode[nums.length * 5];
        buildQueue(queue, nums, 0, nums.length - 1, 0);
        int front = 0;
        for (int i = 1; i < pow2(log2(nums.length) + 1) - 1; i++) {
            if (i % 2 == 1) queue[front].left = queue[i];
            else queue[front++].right = queue[i];
        }
        return queue[0];
    }

    public void buildQueue(TreeNode[] queue, int[] nums, int left, int right, int cur) {
        if (left > right) {
            queue[cur] = null;
            return;
        }
        queue[cur] = new TreeNode(nums[(left + right) / 2]);
        buildQueue(queue, nums, left, (left + right) / 2 - 1, 2 * cur + 1);
        buildQueue(queue, nums, (left + right) / 2 + 1, right, 2 * cur + 2);
    }

    public int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public int pow2(int exp) {
        return (int) Math.pow(2, exp);
    }
}
