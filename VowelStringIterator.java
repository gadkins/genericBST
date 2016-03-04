package genericBST;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VowelStringIterator implements Iterator<String>{
	
	Iterator<String> iterator;
	
	public VowelStringIterator(Iterator<String> baseIterator) {
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
		while (iterator.hasNext()) {
			String next = iterator.next();
			for (Vowels v: Vowels.values()) {
				if(v.name().toString().equals(String.valueOf(next.charAt(0)))) {
					return next;
				}
			}
		}
		throw new NoSuchElementException();
	}
	private enum Vowels {a, e, i, o, u, A, E, I, O, U};
}
