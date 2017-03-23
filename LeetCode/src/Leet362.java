import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sail on 12/14/16.
 * HitCounter
 */
public class Leet362 {
    TreeMap<Integer, Integer> tmap;
    Map<Integer, Integer> cntMap;
    int time;
    /** Initialize your data structure here. */
    public Leet362() {
        tmap = new TreeMap<>();
        cntMap = new HashMap<>();
        time = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        tmap.put(timestamp, time++);
        cntMap.put(timestamp, cntMap.getOrDefault(timestamp, 0) + 1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Integer st = tmap.higherKey(timestamp - 300);
        Integer ed = tmap.floorKey(timestamp);
        if (st == null || ed == null) return 0;
        return tmap.get(ed) - tmap.get(st) + cntMap.get(st);
    }
}

class HitCounter {
    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}