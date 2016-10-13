import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class XYZCoder {
	int[][] f = new int[11000][110];
	int MOD = 1_000_000_007;
	public int countWays(int r, int s) {
		f[0][0] = 1;
		for (int i = 1; i <= r * s; i++) {
			for (int j = 0; j <= r; j++) {
				f[i][j] = f[i - 1][j];
				if (j > 0 && i >= j * s)
					f[i][j] = (f[i - 1][j] + f[i - 1][j - 1]) % MOD;
			}
		}
		int ans = f[r * s][r];
		//System.out.println(ans);
		for (int i = 1; i <= r; i++) {
			ans = (int)(((long)ans * i) % MOD);
		}
		return ans;
	}
}
