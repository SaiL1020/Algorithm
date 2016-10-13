import org.junit.Test;
import static org.junit.Assert.*;

public class FromToDivisibleDiv2Test {
	
	@Test(timeout=2000)
	public void test0() {
		int N = 11;
		int S = 9;
		int T = 9;
		int[] a = new int[] {3,10};
		int[] b = new int[] {5,3};
		assertEquals(2, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int N = 12345;
		int S = 18;
		int T = 12;
		int[] a = new int[] {1,42,50};
		int[] b = new int[] {1,17,3};
		assertEquals(1, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int N = 60;
		int S = 30;
		int T = 8;
		int[] a = new int[] {16,15,12};
		int[] b = new int[] {2,20,5};
		assertEquals(-1, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int N = 77;
		int S = 10;
		int T = 62;
		int[] a = new int[] {2,5,7,4,17,26};
		int[] b = new int[] {25,7,11,13,31,34};
		assertEquals(4, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int N = 100;
		int S = 90;
		int T = 40;
		int[] a = new int[] {20,30,100,99,100};
		int[] b = new int[] {10,30,100,100,99};
		assertEquals(2, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int N = 100000;
		int S = 700;
		int T = 42345;
		int[] a = new int[] {3500,12000,42345,20000,35,19};
		int[] b = new int[] {15,1,700,20000,40000,17};
		assertEquals(3, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int N = 2;
		int S = 1;
		int T = 2;
		int[] a = new int[] {2};
		int[] b = new int[] {1};
		assertEquals(-1, new FromToDivisibleDiv2().shortest(N, S, T, a, b));
	}
}
