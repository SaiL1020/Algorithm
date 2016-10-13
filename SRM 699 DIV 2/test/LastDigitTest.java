import org.junit.Test;
import static org.junit.Assert.*;

public class LastDigitTest {
	
	@Test(timeout=2000)
	public void test0() {
		long S = 1L;
		assertEquals(1L, new LastDigit().findX(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		long S = 565L;
		assertEquals(-1L, new LastDigit().findX(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		long S = 3000L;
		assertEquals(2701L, new LastDigit().findX(S));
	}
	
	@Test(timeout=2000)
	public void test3() {
		long S = 137174210616796L;
		assertEquals(123456789555123L, new LastDigit().findX(S));
	}
	
	@Test(timeout=2000)
	public void test4() {
		long S = 837592744927492746L;
		assertEquals(-1L, new LastDigit().findX(S));
	}
	
	@Test(timeout=2000)
	public void test5() {
		long S = 999999999999999999L;
		assertEquals(900000000000000000L, new LastDigit().findX(S));
	}
}
