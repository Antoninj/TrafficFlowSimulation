package dataStructuresTests;

import dataStructuresGenerics.Matrix;

public class MainMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******************* Matrix test ******************* ");
		System.out.println();

		Matrix myMatrix = new Matrix(4, 5);
		myMatrix.print();

		for (int i = 0; i < myMatrix.rows_size(); i++) {
			for (int j = 0; j < myMatrix.columns_size(); j++) {
				myMatrix.set(i, j, j);

			}
		}
		System.out.println();

		System.out.println(myMatrix);

		System.out.println("Matrix size : " + myMatrix.size());

	}

}
