package genericBST;

public interface INode<E extends Comparable<E>> {
	
	public boolean isNull();
	public boolean isLeaf();
	boolean add(E element, Node<E> parent);
	public boolean contains(E element, Node<E> parent);

}
