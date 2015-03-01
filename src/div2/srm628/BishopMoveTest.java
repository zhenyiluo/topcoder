package div2.srm628;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BishopMoveTest {
	BishopMove bm = new BishopMove();
	@Test
	public void test1() {
		assertEquals(1, bm.howManyMoves(4, 6, 7, 3));
	}
	
	@Test
	public void test2(){
		assertEquals(0, bm.howManyMoves(2, 5, 2, 5));
	}
	
	@Test
	public void test3(){
		assertEquals(2, bm.howManyMoves(1, 3, 5, 5));
	}
	
	@Test
	public void test4(){
		assertEquals(-1, bm.howManyMoves(4, 6, 7, 4));
	}
}
