import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class XMarksTheSpot {
	
	public int countArea(String[] board) {
		int n = board.length, m = board[0].length();
		int minx = n, maxx = 0, miny = m, maxy = 0;
		List<int[]> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i].charAt(j) == 'O') {
					minx = Math.min(minx, i);
					maxx = Math.max(maxx, i);
					miny = Math.min(miny, j);
					maxy = Math.max(maxy, j);
				} else if (board[i].charAt(j) == '?') {
					list.add(new int[]{i, j});
				}
			}
		}

		int ln = list.size();
		int sz = 1 << ln;
		int ans = 0;
		for (int i = 0; i < sz; i++) {
			int cminx = minx, cmaxx = maxx, cminy = miny, cmaxy = maxy;
			for (int j = 0; j < ln; j++) {
				if ((i & (1 << j)) > 0) {
//					System.out.println(i + " " + j);
					int x = list.get(j)[0], y = list.get(j)[1];
					cminx = Math.min(cminx, x);
					cmaxx = Math.max(cmaxx, x);
					cminy = Math.min(cminy, y);
					cmaxy = Math.max(cmaxy, y);
				}
			}
//			System.out.println(cminx + " " + cmaxx + " " + cminy + " " + cmaxy);
			ans += (cmaxx - cminx + 1) * (cmaxy - cminy + 1);
		}
		return ans;
	}
}
