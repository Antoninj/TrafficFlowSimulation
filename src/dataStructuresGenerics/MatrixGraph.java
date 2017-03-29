package dataStructuresGenerics;

public class MatrixGraph {

	private Matrix data;

	public MatrixGraph(int nrNodes) {
		data = new Matrix(nrNodes);
	}
	
	public MatrixGraph(int rows_nbr, int columns_nbr) {
		data = new Matrix(rows_nbr, columns_nbr);
	}

	public void addEdge(int from, int to, double w) {
		data.set(from, to, w);
	}

	public double getEdge(int from, int to) {
		return (Double) data.get(from, to);
	}
	
	public void print(){
		this.data.print();	
	}
	
	public String toString(){
		return this.data.toString();
	}
}
