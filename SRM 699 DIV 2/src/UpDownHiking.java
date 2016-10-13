import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class UpDownHiking {
	
	public int maxHeight(int N, int A, int B) {
		int ans = 0;
		for (int i = 1; i < N; i++) {
			int down = B * (N - i);
			if (A * i <= down) {
				ans += A;
			} else {
				if (ans < down)
					ans += down - ans;
				else if (ans < down - B)
					ans += down - B - ans;
				break;
			}
		}
		return ans;
	}
}
