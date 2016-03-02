package genericBST;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void iterator() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
//		assertTrue(tree.add("G"));
//		assertTrue(tree.add("A"));
//		assertTrue(tree.add("Z"));
//		assertFalse(tree.add("G"));
//		assertTrue(tree.contains("A"));
//		assertFalse(tree.contains("F"));
		Iterator<String> iterator1 = tree.iterator();
		assertNotNull(iterator1);
//		assertFalse(iterator1.hasNext());
//		String first1 = iterator1.next();
//		assertNotNull(first1);
//		Iterator<String> iterator2 = tree.iterator();
//		String first2 = iterator2.next();
//		assertSame(first1, first2);
	}

	@Test
	public void add() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("A"));
		assertTrue(tree.add("Z"));
		assertFalse(tree.add("G"));
		assertFalse(tree.add("A"));
	}
	
	@Test
	public void contains() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.contains("G"));
	}
}
