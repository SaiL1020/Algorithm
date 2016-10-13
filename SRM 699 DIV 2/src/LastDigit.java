import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LastDigit {
	
	public long findX(long S) {
		if (S == Long.MAX_VALUE) return -1;
		long L = S / 2, R = S + 1;
		while (L + 1 < R) {
			long mid = L + (R - L) / 2;
			if (calc(mid) != -1 && calc(mid) <= S) L = mid;
			else R = mid;
		}
		return calc(L) == S ? L : -1;
	}

	private long calc(long n) {
		long ret = 0;
		while (n > 0) {
			if (Long.MAX_VALUE - ret >= n) {
				ret += n;
			} else {
				return -1;
			}
			n /= 10;
		}
		return ret;
	}
}
