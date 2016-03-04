package genericBST;

import java.util.Comparator;

public interface IteratorDecorator<E> extends Comparator<E> {
	
	public boolean hasNext();

	public E next();
	
	public void remove();
}
