package genericBST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class UppercaseIterator implements Iterator<String> {

	List<TreeNode<String>> frontier = new ArrayList<>();
	
	public UppercaseIterator(Iterator<String> baseIterator) {
		TreeNode<String> next;
		while (baseIterator.hasNext()) {
			next = new TreeNode<String>(baseIterator.next());
			frontier.add(next);
		}
	}

	@Override
	public boolean hasNext() {
		return !frontier.isEmpty();
	}

	@Override
	public String next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		TreeNode<String> next = frontier.remove(0);
		if (!next.right.isNull()) {
			frontier.add(next.right);
		}
		if (!next.left.isNull()) {
			frontier.add(next.left);
		}
		return next.element.toUpperCase();
	}
}
