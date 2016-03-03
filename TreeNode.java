package genericBST;

import java.util.Comparator;

public class TreeNode<E extends Comparable<E>> implements Node<E>{

	protected E element;
	protected TreeNode<E> left;
	protected TreeNode<E> right;
	protected Comparator<E> comparator;
	
	public TreeNode() {
		this(null);
	}
	
	public TreeNode(E element) {
		this(element, new NullNode<E>(), new NullNode<E>());
	}
	
	public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public int compare(E object1, E object2) {
		if (this.comparator == null) {
			return object1.compareTo(object2);
		} 
		else {
			return this.comparator.compare(object1, object2);
		}
	}
	
	@Override
	public boolean isNull() {
		return false;
	}
	
	@Override
	public boolean isLeaf() {
		return this.left.isNull() && this.right.isNull();
	}
	
	@Override
	public boolean add(E element, TreeNode<E> parent) {
		int comparison = compare(this.element, element);
		if (comparison > 0) {
			return this.left.add(element, this);
		}
		else if (comparison < 0) {
			return this.right.add(element, this);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(E element, TreeNode<E> parent) {
		int comparison = compare(this.element, element);
		if (comparison > 0) {
			return this.left.contains(element, this);
		}
		else if (comparison < 0) {
			return this.right.contains(element, this);
		}
		else {
			return true;
		}
	}
	
	public TreeNode<E> getLeft() {
		return this.left;
	}
	
	public TreeNode<E> getRight() {
		return this.right;
	}
	
//	private static final class NullNode<E extends Comparable<E>> extends Node<E> 	{
//
//		private NullNode() {
//			super(null, null, null);
//		}
//		
//		@Override
//		public boolean isNull() {
//			return true;
//		}
//		
//		@Override
//		public boolean isLeaf() {
//			return false;
//		}
//		
//		@Override
//		public boolean add(E element, Node<E> parent) {
//			int comparison = compare(parent.element, element);
//			if (comparison > 0) {
//				parent.left = new Node<E>(element);
//			}
//			else if (comparison < 0) {
//				parent.right = new Node<E>(element);
//			}
//			return true;
//		}
//		
//		@Override
//		public boolean contains(E element, Node<E> parent) {
//			return false;
//		}
//	 }
}
