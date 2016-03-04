package genericBST;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class VowelStringIteratorTest {

	@Test
	public void test() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("date"));
		assertTrue(tree.add("banana"));
		assertTrue(tree.add("elderberry"));
		assertTrue(tree.add("apple"));
		assertTrue(tree.add("cherry"));
		assertTrue(tree.add("fig"));
		assertTrue(tree.add("orange"));
		Iterator<String> treeIterator = tree.iterator();
		VowelStringIterator vowels = new VowelStringIterator(treeIterator);
		String apple = vowels.next();
		assertEquals("apple", apple);
		String elderberry = vowels.next();
		assertEquals( "elderberry", elderberry);
		String orange = vowels.next();
		assertEquals( "orange", orange);
	}

}
