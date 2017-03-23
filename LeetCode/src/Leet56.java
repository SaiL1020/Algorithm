import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by sail on 9/16/16.
 * Code one more line :)
 */
public class Leet56 {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        int k = 1;
        while (k < intervals.size()) {
            //System.out.println(intervals.size());
            //System.out.println(intervals.get(k).start + " " + intervals.get(k - 1).end);
            while (k < intervals.size() && intervals.get(k).start > intervals.get(k - 1).end) {
                //System.out.println("k: " + k);
                k++;
            }

            if (0 < k && k < intervals.size() && intervals.get(k).end >= intervals.get(k - 1).start) {
                Interval newInv = new Interval(Math.min(intervals.get(k).start, intervals.get(k - 1).start),
                                                Math.max(intervals.get(k).end, intervals.get(k - 1).end));
                System.out.println((k - 1) + " " + newInv.start + " " + newInv.end);
                intervals.remove(k - 1);
                intervals.remove(k - 1);
                intervals.add(k - 1, newInv);
                System.out.println("============");
                for (Interval i : intervals) {
                    System.out.println(i.start + " " + i.end);
                }
                System.out.println("============");
            }

        }
        return intervals;
    }

    public void run() {
        List<Interval> intervals = new LinkedList<>();
        //[[5,5],[1,2],[2,4],[2,3],[4,4],[5,5],[2,3],[5,6],[0,0],[5,6]]
        intervals.add(new Interval(5,5));
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(4,4));
        intervals.add(new Interval(5,5));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(0,0));
        intervals.add(new Interval(5,6));
        intervals = merge(intervals);
        for (Interval i : intervals) {
            System.out.println(i.start + " " + i.end);
        }
    }
    public static void main(String[] args) {
        new Leet56().run();
    }
}
