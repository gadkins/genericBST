package genericBST;

import static org.junit.Assert.*;
import java.util.TreeSet;

import java.util.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void BinarySearchTree() {
		BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
		BinarySearchTree<String> tree2 = new BinarySearchTree<String>();
		assertNotNull(tree1);
		assertNotSame(tree1,tree2);
	}
	
	@Test
	public void hasNext() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("h"));
		Iterator<String> stringIterator = tree.iterator();
		assertNotNull(stringIterator);
		assertTrue(stringIterator.hasNext());
		assertTrue(stringIterator.hasNext());
		assertFalse(stringIterator.hasNext());
	}
	
	@Test
	public void next() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
	}

	@Test
	public void add() {
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
	public void contains() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("G"));
		assertTrue(tree.add("A"));
		assertTrue(tree.contains("A"));
		assertTrue(tree.add("Z"));
		assertFalse(tree.add("G"));
		assertTrue(tree.contains("A"));
		assertFalse(tree.contains("F"));
	}
	
}
