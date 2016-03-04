package genericBST;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class UppercaseIteratorTest {

	@Test
	public void test() {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		assertTrue(tree.add("hello"));
		assertTrue(tree.add("world"));
		assertTrue(tree.add("how"));
		assertTrue(tree.add("are"));
		assertTrue(tree.add("you"));
		Iterator<String> treeIterator = tree.iterator();
		UppercaseIterator upper = new UppercaseIterator(treeIterator);
		String hello = upper.next();
		assertEquals("HELLO", hello.toUpperCase());
		String are = upper.next();
		assertEquals( "ARE", are.toUpperCase());
		String world = upper.next();
		assertEquals( "WORLD", world.toUpperCase());
		String how = upper.next();
		assertEquals( "HOW", how.toUpperCase());
		String you = upper.next();
		assertEquals( "YOU", you.toUpperCase());
	}

}
