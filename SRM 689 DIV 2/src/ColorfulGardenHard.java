import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ColorfulGardenHard {
	public int mod = 1000000007;

	public int count(String garden, String forbid) {
		int n = garden.length();
		int[] freq = new int[26];
		for (char c : garden.toCharArray())
			freq[c - 'a']++;
		int[] dp = new int[1 << n];
		dp[0] = 1;
		for (int i = 0; i < 26; i++) {
			if (freq[i] == 0) continue;
			int[][][] next = new int[n + 1][freq[i] + 1][1 << n];
			next[0][0] = dp;
			for (int pos = 1; pos <= n; pos++) {
				for (int left = 0; left <= freq[i]; left++) {
					for (int mask = 0; mask < 1 << n; mask++) {
						next[pos][left][mask] = (next[pos][left][mask] + next[pos - 1][left][mask]) % mod;
						if (left > 0 && (((mask >> (pos - 1)) & 1) > 0) && forbid.charAt(pos - 1) -'a' != i) {
							next[pos][left][mask] = (next[pos][left][mask] + next[Math.max(pos - 2, 0)][left - 1][mask ^ (1 << (pos - 1))]) % mod;
						}
					}
				}
			}
			dp = next[n][freq[i]];
			//System.out.println(i);
			//print(next);
		}
		return dp[(1 << n) - 1];
	}

	public void print(int[][][] next) {
		for (int[][] n : next) {
			for (int[] nn : n) {
				for (int nnn : nn){
					System.out.print(nnn + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}
}