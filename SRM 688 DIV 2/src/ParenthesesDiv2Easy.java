import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ParenthesesDiv2Easy {
	
	public int getDepth(String s) {
		int ret = 0, cnt = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '(') cnt++;
			else cnt--;
			ret = Math.max(cnt, ret);
		}
		return ret;
	}
}
