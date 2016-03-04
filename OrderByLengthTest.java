package genericBST;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderByLengthTest {

	@Test
	public void testCompare() {
		OrderByLength lengthOrder = new OrderByLength();
		BinarySearchTree<String> tree = new BinarySearchTree<String>(lengthOrder);
		assertTrue(tree.add("cat"));
		assertTrue(tree.add("crazy"));
		assertFalse(tree.add("I'm"));
		assertTrue(tree.add("like"));
		assertTrue(tree.add("a"));
		String s = tree.toString();
		assertEquals("[cat, a, crazy, like]", s);
	}

}
