import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Xylophone {
	
	public int countKeys(int[] keys) {
		int[] cnt = new int[7];
		for (int i = 0; i < keys.length; i++) {
			cnt[(keys[i] - 1) % 7]++;
		}
		int ret = 0;
		for (int i = 0; i < 7; i++) {
			if (cnt[i] != 0) ret++;
		}
		return ret;
	}
}
