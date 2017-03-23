import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sail on 6/14/16.
 * findOrder of prerequisites
 */
public class Leet210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] degree = new int[numCourses][2]; // 0 in; 1 out
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];
            degree[in][0]++;
            degree[out][1]++;
            List<Integer> list;
            if (!hm.containsKey(out)) {
                list = new ArrayList<>();
            } else {
                list = hm.get(out);
            }
            list.add(in);
            hm.put(out, list);
        }
        List<Integer> ret = new ArrayList<>();
        List<Integer> hs = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++)
            hs.add(i);
        while (!hs.isEmpty()) {
            boolean hasZeroIn = false;
            for (int i = 0; i < hs.size(); i++) {
                int in = hs.get(i);
                if (degree[in][0] == 0) {
                    hasZeroIn = true;
                    ret.add(in);
                    hs.remove(new Integer(in));
                    List<Integer> list = hm.get(in);
                    if (list == null) break;
                    for (int j = 0; j < list.size(); j++) {
                        int out = list.get(j);
                        degree[out][0]--;
                    }
                }
            }
            if(!hasZeroIn)
                break;
        }
        int[] arr = new int[0];
        if (hs.isEmpty())
            arr = ret.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
