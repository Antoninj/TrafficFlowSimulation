package dataStructuresGenerics;

public class DictionaryPair<T extends Comparable<T>, U extends Comparable<U>>
		implements Comparable<DictionaryPair<T, U>> {
	private T key;
	private U value;

	public DictionaryPair(T someKey, U someValue) {
		this.key = someKey;
		this.value = someValue;
	}

	public DictionaryPair(T compareKey) {
		this.key = compareKey;
	}

	public T getKey() {
		return this.key;
	}

	public U getValue() {
		return this.value;
	}

	public void setKey(T newKey) {
		this.key = newKey;
	}

	public void setValue(U newValue) {
		this.value = newValue;
	}

	public String toString() {
		String s = "{" + this.key.toString() + ":" + this.value.toString() + "}";
		return s;
	}

	@Override
	public int compareTo(DictionaryPair<T, U> pair) {
		 return this.key.compareTo(pair.getKey());
	}
}