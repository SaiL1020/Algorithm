import lib.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sail on 11/10/16.
 * path Sum
 */
public class Leet437 {
    Map<Integer, Integer> sumToSize;
    int Sum;
    public int pathSum(TreeNode root, int sum) {
        sumToSize = new HashMap<>();
        Sum = sum;
        return countRoot(root, 0);
    }
    private int countRoot(TreeNode root, int pre) {
        if (root == null) return 0;
        root.val += pre;
        int res = (root.val == Sum ? 1 : 0) + count(Sum - root.val);
        sumToSize.put(root.val, sumToSize.getOrDefault(root.val, 0) + 1);
        res += countRoot(root.left, root.val) + countRoot(root.right, root.val);
        if (sumToSize.get(root.val) - 1 == 0) sumToSize.remove(root.val);
        else sumToSize.put(root.val, sumToSize.get(root.val) - 1);
        return res;
    }
    private int count(int k) {
        Map<Integer, Integer> sumToCount = sumToSize.entrySet().stream()
                .filter(p -> p.getKey() == k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return sumToCount.size();
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("a", new LinkedList<>());
        map.get("a").add(1);
        map.get("a").remove(0);
        System.out.println(map.get("a").size());
    }
}
