package genericBST;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.ArrayList;

public class BinarySearchTree<E  extends Comparable<E>> extends AbstractSet<E> {
	private HeadNode head;
	private TreeNode<E> root;
	private Comparator<E> comparator;
	private int size = 0;
	
	public BinarySearchTree() {
		this.head = new HeadNode();
		this.root = null;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Iterator<E> treeIterator = this.iterator();
		if (!treeIterator.hasNext()) {
			builder.append("[ ]");
		}
		else {
			builder.append("[");
			while (treeIterator.hasNext()) {
				E nextItem = treeIterator.next();
				builder.append(nextItem.toString());
				if (treeIterator.hasNext()) {
					builder.append(", ");
				}
			}
			builder.append("]");
		}
		return builder.toString();
	}
	
	@Override
	public Object[] toArray() {
		Object[] container = new Object[this.size()];
		Iterator<E> treeIterator = this.iterator();
		int count = 0;
		while (treeIterator.hasNext()) {
			E nextItem = treeIterator.next();
			container[count++] = nextItem;
		}
		return container;
	}
	
	@Override
	public boolean isEmpty() {
		return this.root == null;
	}
	
	@Override
	/*
	 * Add a new element into a tree
	 * 
	 * @param	element		The element to be inserted into the tree
	 * @return				Returns true if insertion was successful, else returns false
	 */
	public boolean add(E element) {
		boolean result = head.add(element, root);
		if (result) {
			this.size++; 
		}
		return result;
	}
	
	/*
	 * Check if a tree contains element
	 * 
	 * @param	element		The element in question
	 * @return				Returns true if tree contains element, else returns false
	 */
	public boolean contains(E element) {
		return head.contains(element, root);
	}
	
	
	interface TreeIterator<E> extends Iterator<E> { }

	private class BinarySearchTreeIterator implements TreeIterator<TreeNode<E>> {
		private Stack<TreeNode <E>> frontier = new Stack<TreeNode<E>>();
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
		public TreeNode<E> next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			TreeNode<E> nextNode = frontier.pop();
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
	
	private final class HeadNode extends TreeNode<E> implements Node<E>{
		
		public HeadNode() { }
		@Override
		public boolean isNull() {
			return true;
		}

		@Override
		public boolean isLeaf() {
			return false;
		}

		@Override
		public boolean add(E element, TreeNode<E> root) {
			if (BinarySearchTree.this.isEmpty()) {
				BinarySearchTree.this.root = new TreeNode<E>(element);
				return true;
			}
			else {
				return root.add(element, root);
			}
		}

		@Override
		public boolean contains(E element, TreeNode<E> root) {
			return root.contains(element, root);
		}
	}
}