import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FromToDivisibleDiv2 {
	
	public int shortest(int N, int S, int T, int[] a, int[] b) {
		int m = a.length;
		Queue<Integer> queue = new LinkedList<>();
		int[] dis = new int[m];
		for (int i = 0; i < m; i++) {
			if (S % a[i] == 0) {
				dis[i] = 1;
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int i = queue.poll();
			if (T % b[i] == 0) return dis[i];
			for (int j = 0; j < m; j++) {
				if (dis[j] == 0 && lcm(b[i], a[j]) <= N) {
					dis[j] = dis[i] + 1;
					queue.add(j);
				}
			}
		}
		return -1;
	}
	private int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
	private long lcm(int a, int b) {
		return (long) a * b / gcd(a, b);
	}
}
