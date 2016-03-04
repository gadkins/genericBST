package genericBST;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testBinarySearchTree() {
		BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
		BinarySearchTree<String> tree2 = new BinarySearchTree<String>();
		assertNotNull(tree1);
		assertNotSame(tree1,tree2);
	}
	
	@Test
	public void testSize() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("h"));
		assertTrue(tree.add("apple"));
		assertTrue(tree.add("zebra"));
		assertEquals(4, tree.size());
	}
	
	@Test
	public void testIterator() {
		testHasNext();
		testNext();
	}
	
	@Test
	public void testHasNext() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("h"));
		Iterator<String> stringIterator = tree.iterator();
		assertNotNull(stringIterator);
		assertTrue(stringIterator.hasNext());
		String next = stringIterator.next();
		assertTrue(stringIterator.hasNext());
		next = stringIterator.next();
		assertFalse(stringIterator.hasNext());
	}
	
	@Test
	public void testNext() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("date"));
		assertTrue(tree.add("banana"));
		assertTrue(tree.add("apple"));
		assertTrue(tree.add("cherry"));
		Iterator<String> treeIterator = tree.iterator();
		String date = treeIterator.next();
		assertEquals("date", date);
		String banana = treeIterator.next();
		assertEquals( "banana", banana);
		String apple = treeIterator.next();
		assertEquals( "apple", apple);
	}

	@Test
	public void testAdd() {
		BinarySearchTree<String> stringTree = new BinarySearchTree<String>();
		assertTrue(stringTree.add("G"));
		assertTrue(stringTree.add("a"));
		assertTrue(stringTree.add("Z"));
		assertFalse(stringTree.add("G"));
		assertTrue(stringTree.contains("G"));
		assertTrue(stringTree.contains("a"));
		assertTrue(stringTree.contains("Z"));
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		assertTrue(intTree.add(5));
		assertTrue(intTree.add(3));
		assertTrue(intTree.add(8));
		assertTrue(intTree.contains(5));
		assertTrue(intTree.contains(3));
		assertTrue(intTree.contains(8));
	}
	
	@Test
	public void testContains() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("A"));
		assertTrue(tree.contains("A"));
		assertTrue(tree.add("Z"));
		assertFalse(tree.add("G"));
		assertTrue(tree.contains("A"));
		assertFalse(tree.contains("F"));
	}
	
	@Test
	public void testToString() {
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		assertTrue(intTree.add(5));
		assertTrue(intTree.add(3));
		assertTrue(intTree.add(8));
		String result = intTree.toString();
		assertEquals("[5, 3, 8]", result);
	}
	
	@Test
	public void testToArray() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		String s1 = "date";
		String s2 = "banana";
		String s3 = "apple";
		String s4 = "cherry";
		assertTrue(tree.add(s1));
		assertTrue(tree.add(s2));
		assertTrue(tree.add(s3));
		assertTrue(tree.add(s4));
		Object[] arr1 = tree.toArray();
		Object[] arr2 = {s1,s2,s3,s4};
		assertArrayEquals(arr2,arr1);
	}
}
