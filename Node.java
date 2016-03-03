package genericBST;

import java.util.Comparator;

public class Node<E extends Comparable<E>> implements INode<E>{

	protected E element;
	protected Node<E> left;
	protected Node<E> right;
	protected Comparator<E> comparator;
	
	public Node() {
		this(null);
	}
	
	public Node(E element) {
		this(element, new NullNode<E>(), new NullNode<E>());
	}
	
	private Node(E element, Node<E> left, Node<E> right) {
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
	public boolean add(E element, Node<E> parent) {
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
	public boolean contains(E element, Node<E> parent) {
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
	
	public Node<E> getLeft() {
		return this.left;
	}
	
	public Node<E> getRight() {
		return this.right;
	}
	
	private static final class NullNode<E extends Comparable<E>> extends Node<E> 	{

		private NullNode() {
			super(null, null, null);
		}
		
		@Override
		public boolean isNull() {
			return true;
		}
		
		@Override
		public boolean isLeaf() {
			return false;
		}
		
		@Override
		public boolean add(E element, Node<E> parent) {
			//parent = this;
			int comparison = compare(parent.element, element);
			if (comparison > 0) {
				parent.left = new Node<E>(element);
			}
			else if (comparison < 0) {
				parent.right = new Node<E>(element);
			}
//			parent = new Node<E>(element);
			return true;
		}
		
		@Override
		public boolean contains(E element, Node<E> parent) {
			return false;
		}
	}
}
