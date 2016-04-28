import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NonDeterministicSubstring {
	
	public long ways(String A, String B) {
		HashSet<String> hs = new HashSet<String>();
		int lengthA = A.length(), lengthB = B.length();

		for (int i = 0; i + lengthB <= lengthA; i++) {
			boolean isContained = true;
			for (int j = 0; j < lengthB; j++) {
				if (B.charAt(j) != '?' && B.charAt(j) != A.charAt(i + j)) {
					isContained = false;
					break;
				}
			}
			if (isContained)
				hs.add(A.substring(i, i + lengthB));
		}

		return hs.size();
	}
}
