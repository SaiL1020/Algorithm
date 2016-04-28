import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ParenthesesDiv2Medium {

	// keep the stack size at most 2

	public int[] correct(String s) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int top = 0;
		for (int i = 0; i < s.length(); ++ i) {
			if (s.charAt(i) == ')') {
				if (top == 0) {
					ret.add(i);
					++ top;
				} else {
					-- top;
				}
			} else {
				if (top == 2 || i == s.length() - 1) {
					ret.add(i);
					-- top;
				} else {
					++ top;
				}
			}
		}
		/* for print purpose
		for (int i = 0; i < s.length() / 2 + 1; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();
		*/

		/* 1st method to convert ArrayList to int[]
		 * note: may get NullPointerException
		 * the access to the list is not O(1) !!!
		int[] array = new int[ret.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = ret.get(i);
		}
		*/

		/* 2nd method
		 * use the list iterator to avoid nasty costs with lists such as LinkedList
		int[] array2 = new int[ret.size()];
		Iterator it = ret.iterator();
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (Integer) it.next();
		}
		*/

		// Java 8
		// What it does is:
		//   getting a Stream<Integer> from the list
		//   obtaining an IntStream by mapping each element to itself (identity function),
		//       unboxing the int value hold by each Integer object (done automatically since Java 5)
		//   getting the array of int by calling toArray
		// To avoid null elements
		//   ret.stream().mapToInt(i -> i != null).toArray()
		return ret.stream().mapToInt(i -> i).toArray();
	}
}
