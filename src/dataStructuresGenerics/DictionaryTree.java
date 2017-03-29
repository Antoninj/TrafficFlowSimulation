package dataStructuresGenerics;

public class DictionaryTree<T extends Comparable<T>, U extends Comparable<U>> {

	private Tree<DictionaryPair<T, U>> data;

	public DictionaryTree() {
		this.data = new Tree<DictionaryPair<T, U>>();
	}

	public void add(T key, U value) {

		DictionaryPair<T, U> newPair = new DictionaryPair<T, U>(key, value);
		this.data.insert(newPair);
	}

	public U find(T key) {
		DictionaryPair<T, U> somePair = new DictionaryPair<T, U>(key);
		DictionaryPair<T, U> FoundPair = this.data.find(somePair);

		if (FoundPair != null) {
			return FoundPair.getValue();
		} else {
			return null;
		}
	}

	public void print(boolean width) {
		this.data.print(width);
	}

}
