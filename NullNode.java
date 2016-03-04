package genericBST;

import java.util.Comparator;

public final class NullNode<E extends Comparable<E>> extends TreeNode<E> implements Node<E> {
	
		protected Comparator<E> comparator;
	
		public NullNode() {
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
		public boolean add(E element, TreeNode<E> parent, Comparator<E> comp) {
			this.comparator = comp;
			int comparison = compare(parent.element, element);
			if (comparison > 0) {
				parent.left = new TreeNode<E>(element);
			}
			else if (comparison < 0) {
				parent.right = new TreeNode<E>(element);
			}
			return true;
		}
		
		@Override
		public boolean contains(E element, TreeNode<E> parent, Comparator<E> comp) {
			return false;
		}
}
