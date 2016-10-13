import org.junit.Test;
import static org.junit.Assert.*;

public class XYZCoderTest {
	
	@Test(timeout=2000)
	public void test0() {
		int room = 2;
		int size = 1;
		assertEquals(2, new XYZCoder().countWays(room, size));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int room = 1;
		int size = 2;
		assertEquals(1, new XYZCoder().countWays(room, size));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int room = 2;
		int size = 2;
		assertEquals(4, new XYZCoder().countWays(room, size));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int room = 4;
		int size = 5;
		assertEquals(6840, new XYZCoder().countWays(room, size));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int room = 100;
		int size = 100;
		assertEquals(718243627, new XYZCoder().countWays(room, size));
	}
}
