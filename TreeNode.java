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
	public boolean add(E element, TreeNode<E> parent, Comparator<E> comp) {
		this.comparator = comp;
		int comparison = compare(this.element, element);
		if (comparison > 0) {
			return this.left.add(element, this, comp);
		}
		else if (comparison < 0) {
			return this.right.add(element, this, comp);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(E element, TreeNode<E> parent, Comparator<E> comp) {
		this.comparator = comp;
		int comparison = compare(this.element, element);
		if (comparison > 0) {
			return this.left.contains(element, this, comp);
		}
		else if (comparison < 0) {
			return this.right.contains(element, this, comp);
		}
		else {
			return true;
		}
	}
}
