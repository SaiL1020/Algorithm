import org.junit.Test;
import static org.junit.Assert.*;

public class NonDeterministicSubstringTest {
	
	@Test(timeout=2000)
	public void test0() {
		String A = "00010001";
		String B = "??";
		assertEquals(3L, new NonDeterministicSubstring().ways(A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String A = "00000000";
		String B = "??0??0";
		assertEquals(1L, new NonDeterministicSubstring().ways(A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String A = "001010101100010111010";
		String B = "???";
		assertEquals(8L, new NonDeterministicSubstring().ways(A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String A = "00101";
		String B = "??????";
		assertEquals(0L, new NonDeterministicSubstring().ways(A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String A = "1101010101111010101011111111110001010101";
		String B = "???????????????????????????????????";
		assertEquals(6L, new NonDeterministicSubstring().ways(A, B));
	}
}
