import java.util.*;

/**
 * Created by sail on 12/14/16.
 * sequence Reconstruction
 */
public class Leet444 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i : seq) {
                map.putIfAbsent(i, new HashSet<>());
                indegree.putIfAbsent(i, 0);
            }
        }

        for (int[] seq : seqs) {
            if (seq.length == 1) continue;
            for (int i = 1; i < seq.length; i++)
                if (map.get(seq[i - 1]).add(seq[i]))
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
        }

        if (org.length != indegree.size()) return false;

        Queue<Integer> q = new ArrayDeque<>();
        for (int key : indegree.keySet())
            if (indegree.get(key) == 0) q.add(key);

        int cnt = 0;
        while (q.size() == 1) {
            for (int next : map.get(q.poll())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
            cnt++;
        }

        return cnt == indegree.size();
    }
}
