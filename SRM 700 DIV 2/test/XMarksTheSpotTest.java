import org.junit.Test;
import static org.junit.Assert.*;

public class XMarksTheSpotTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {
"?.",
".O"
};
		assertEquals(5, new XMarksTheSpot().countArea(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {
"???",
"?O?",
"???"
};
		assertEquals(1952, new XMarksTheSpot().countArea(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {
"...?.",
"?....",
".O...",
"..?..",
"....?"
};
		assertEquals(221, new XMarksTheSpot().countArea(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"OOOOOOOOOOOOOOOOOOOOO"};
		assertEquals(21, new XMarksTheSpot().countArea(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"?????????OO??????????"};
		assertEquals(9963008, new XMarksTheSpot().countArea(board));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] board = new String[] {
"OOO",
"O?O",
"OOO",
"..."
};
		assertEquals(18, new XMarksTheSpot().countArea(board));
	}
}
