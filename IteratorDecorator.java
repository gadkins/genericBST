package genericBST;

import java.util.Iterator;

public abstract class IteratorDecorator<E> implements Iterator<E> {

	protected Iterator<E> decoratedIterator;
	
	public IteratorDecorator(Iterator<E> decoratedIterator) {
		this.decoratedIterator = decoratedIterator;
	}
	
	
	// Abstract here may not be a good idea. Consider writing definitions and allowing subclasses to inherit
	public abstract boolean hasNext();

	public abstract E next();
	
	public abstract void remove();
}
