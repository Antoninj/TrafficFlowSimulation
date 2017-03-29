package dataStructuresGenerics;

public class Matrix {

	private int rows; // number of rows
	private int columns; // number of columns
	private Comparable[][] data; // M-by-N array

	// create M-by-N matrix of 0's
	public Matrix(int rows_nbr, int columns_nbr) {
		this.rows = rows_nbr;
		this.columns = columns_nbr;

		data = new Comparable[rows_nbr][columns_nbr];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				this.data[i][j] = 0;
	}

	public Matrix(int nrNodes) {
		this.rows = nrNodes;
		this.columns = nrNodes;
		data = new Comparable[nrNodes][nrNodes];

		for (int i = 0; i < nrNodes; i++)
			for (int j = 0; j < nrNodes; j++)
				this.data[i][j] = 0;
	}

	// swap rows i and j
	public void swap(int i, int j) {
		Comparable[] temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public void set(int row, int col, Comparable weight) {
		// store the weight at the given row and column.
		this.data[row][col] = weight;
	}

	public int size() {
		return this.rows * this.columns;
	}

	public int rows_size() {
		return rows;
	}

	public int columns_size() {
		return columns;
	}

	public Comparable get(int row, int col) {
		// return the weight at the given row and column.
		return this.data[row][col];
	}

	// print matrix to standard output
	public void print() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				System.out.print(this.get(i, j) + " ");
			}
			System.out.println();
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				s += this.get(i, j) + " ";
			}
			s += "\n";
		}
		return s;
	}
}
