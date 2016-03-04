package genericBST;

import java.util.Comparator;

public interface Node<E extends Comparable<E>> {
	
	public boolean isNull();
	public boolean isLeaf();
	boolean add(E element, TreeNode<E> parent, Comparator<E> comp);
	public boolean contains(E element, TreeNode<E> parent, Comparator<E> comp);

}
