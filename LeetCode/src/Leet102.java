import lib.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Created by sail on 9/2/16.
 * Code one more line :)
 */
public class Leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;


        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> lvl = new LinkedList<>();
            int sz = que.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = que.poll();
                lvl.add(cur.val);
                if (cur.left != null) que.add(cur.left);
                if (cur.right != null) que.add(cur.right);
            }
            ans.add(lvl);
        }

        return ans;
    }
    public static void main(String[] args) {
        new Leet102().run();
    }
    public void run() {
        TreeNode root = new TreeNode().buildTree(new Object[]{1,2,null,3,null,4,null,5});
        print(levelOrder(root));
    }
    public void print(List<List<Integer>> ans) {
        for (List<Integer> l : ans) {
            for (int k : l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
