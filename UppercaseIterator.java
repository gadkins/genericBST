package genericBST;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class UppercaseIterator implements Iterator<String> {

	Iterator<String> iterator;
	public UppercaseIterator(Iterator<String> baseIterator) {
		this.iterator = baseIterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public String next() {
		if (!iterator.hasNext()) {
			throw new NoSuchElementException();
		}
		return iterator.next().toUpperCase();
	}
}
