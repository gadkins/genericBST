package genericBST;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

//package genericBST;
//
//import java.util.Iterator;
//
//interface TreeIterator<E> extends Iterator<E> { }

//private class BinarySearchTreeIterator<E extends Comparable<E>> implements Iterator<E> {
//	private Stack<TreeNode<E>> frontier = new Stack<TreeNode<E>>();
//	private BinarySearchTreeIterator() {
//		if (!root.isNull()) {
//			frontier.push(root);
//		}
//	}
//	@Override
//	public boolean hasNext() {
//		return !frontier.empty();
//	}
//	@Override
//	public E next() {
//		if (!this.hasNext()) {
//			throw new NoSuchElementException();
//		}
//		TreeNode<E> next = frontier.pop();
//		if (!next.left.isNull()) {
//			frontier.push(next.left);
//		}
//		if (!next.right.isNull()) {
//			frontier.push(next.right);
//		}
//		return next.element;
//	}
//	@Override
//	public void remove() {
//		throw new UnsupportedOperationException("Removing from the tree is not supported.");
//	}
//}
