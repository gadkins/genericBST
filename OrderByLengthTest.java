package genericBST;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderByLengthTest {

	@Test
	public void testCompare() {
		OrderByLength lengthOrder = new OrderByLength();
		BinarySearchTree<String> tree = new BinarySearchTree<String>(lengthOrder);
		assertTrue(tree.add("G"));
		assertTrue(tree.add("camp"));
		assertTrue(tree.add("rat"));
		assertTrue(tree.add("Hahahaha"));
		assertTrue(tree.add("hello"));
		String s = tree.toString();
		assertEquals("[Hahahaha, hello, camp, rat, G]", s);
	}

}
