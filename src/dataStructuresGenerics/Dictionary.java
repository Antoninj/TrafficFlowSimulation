package dataStructuresGenerics;

public class Dictionary<T extends Comparable<T>, U extends Comparable<U>> {

	private LinkedList<DictionaryPair<T, U>> data;

	public Dictionary() {
		this.data = new LinkedList<DictionaryPair<T, U>>();
	}

	public void add(T key, U value) {

		int position = findPosition(key);

		if (position == -1) {
			DictionaryPair<T, U> newPair = new DictionaryPair<T, U>(key, value);
			this.data.addLast(newPair);
		} else {
			this.data.get(position).setValue(value);
		}
	}

	public int findPosition(T key) {
		for (int i = 0; i < this.data.size(); i++) {
			if (this.data.get(i).getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}

	public U find(T key) {
		int position = findPosition(key);
		if (position != -1) {
			return this.data.get(position).getValue();
		} else {
			return null;
		}
	}

	public U find(int index) {
		return this.data.get(index).getValue();
	}

	public String toString() {
		return this.data.toString();
	}

	public int size() {
		return this.data.size();
	}

}
