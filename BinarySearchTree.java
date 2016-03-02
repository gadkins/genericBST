package genericBST;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractSet<E> {
	private Node<E> root;
	private Comparator<E> comparator;
	private int size = 0;
	
	public BinarySearchTree() {
		this.comparator = null;
	}
	
	public BinarySearchTree(Comparator<E> c) {
		this.comparator = c;
	}
	
	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) new BinarySearchTreeIterator();
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	private int compare(E object1, E object2) {
		if (this.comparator == null) {
			return object1.compareTo(object2);
		} 
		else {
			return this.comparator.compare(object1, object2);
		}
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	/*
	 * Add a new element into the tree
	 * 
	 * @param	element		The element to be inserted into the tree
	 * @return				Returns true if insertion was successful, else returns false
	 */
	public boolean add(E element) {
		if (this.isEmpty()) {
			root = new Node<E>(element);
			this.size++;
			return true;
		}
		boolean result = root.add(element, root);
		if (result) {
			this.size++; 
		}
		return result;
	}
	
	public boolean contains(E element) {
		if (this.isEmpty()) {
			return false;
		}
		return root.contains(element, root);
	}
	
//	public String toString() {
//		// StringBuilder
//	}
	
	
	interface TreeIterator<E> extends Iterator<E> { }

	private class BinarySearchTreeIterator implements TreeIterator<Node<E>> {
		private Stack<Node <E>> frontier = new Stack<Node<E>>();
		private BinarySearchTreeIterator() {
			if (root != null) {
				frontier.push(root);
			}
		}
		@Override
		public boolean hasNext() {
			return !frontier.empty();
		}
		@Override
		public Node<E> next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException("No more items in the tree");
			}
			Node<E> nextNode = frontier.pop();
			if (nextNode.getRight() != null) {
				frontier.push(nextNode.getRight());
			}
			if (nextNode.left != null) {
				frontier.push(nextNode.getLeft());
			}
			return nextNode;
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Removing from the tree is not supported.");
		}
	}
	
//	private final class HeadNode {
//		private HeadNode() {
//			BinarySearchTree.this.root = 
//		}
//	}
}