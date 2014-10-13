package com.test.test;

/**
 * Matrix
 * This class allows you to create a two-dimensional Matrix of integers.
 * This can be changed quite easily if you require an array of a different kind of value.
 * @author Jake Alsemgeest
 *
 */
class Matrix {
	public int[][] matrix;
	public int height;
	public int width;
	
	/**
	 * Matrix
	 * This will take in a two-dimensional array along with a height and width to create a Matrix object.
	 * @param matrix - two-dimensional array. (Ex. int[][] i = {{1,2},{3,4}})
	 * @param height - the height of the array. (Not 0 indexed). In above example, it would be 2.
	 * @param width - the width of the array.  (Not 0 indexed). In the above example, it would be 2.
	 */
	public Matrix(int[][] matrix, int height, int width) {
		this.matrix = matrix;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * Matrix
	 * This will take in a String, along with the height and width of a given matrix to create one.
	 * @param s - A string in the form of a two-dimensional array, seperated by commas.
	 * 			(Ex. String s = 1,2,3,4,5,6,7,8) - if height was 4 and width was 2, then it would create
	 * 			the array of int[][] array = {{1,2},{3,4},{5,6},{7,8}}.
	 * @param height - the height of the matrix. (Not 0 indexed.)
	 * @param width - the width of the matrix. (Not 0 indexed.)
	 */
	public Matrix(String s, int height, int width) {
		String x[] = (s.replace("\n", "").split(","));
		this.matrix = new int[height][width];
		this.height = height;
		this.width = width;
		int count = 0;
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				matrix[i][j] = Integer.parseInt(x[count]);
				count++;
			}
		}
	}
	
	/**
	 * Matrix
	 * This will create a randomly generated matrix based on the number provided,
	 * with the given height and width
	 * @param height - The height of the matrix that will be created. 
	 * @param width - The width of the matrix that will be created.
	 * @param number - The upper limit of the random numbers that will be entered into the matrix.
	 */
	public Matrix(int height, int width, int number) {
		this.matrix = new int[height][width];
		this.height = height;
		this.width = width;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = (int) (Math.random() * number);
			}
		}
	}
	
	/**
	 * flipVertically
	 * This will take the given Matrix and return a Matrix that has been flipped Vertically.
	 * @return Matrix - this will be flipped vertically.
	 * Ex.
	 * 1,2,3    3,2,1
	 * 4,5,6 -> 6,5,4
	 * 7,8,9    9,8,7
	 */
	public Matrix flipVertically() {
		Matrix n = new Matrix(this.toString(), height, width);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				n.matrix[i][j] = matrix[i][width - j - 1];
			}
		}
		return n;
	}
	
	/**
	 * flipHorizontally
	 * This will take the given Matrix and return a Matrix that has been flipped Horizontally.
	 * @return Matrix - thie will be flipped horizontally.
	 * Ex.
	 * 1,2,3    7,8,9
	 * 4,5,6 -> 4,5,6
	 * 7,8,9    1,2,3
	 */
	public Matrix flipHorizontally() {
		Matrix n = new Matrix(this.toString(), height, width);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				n.matrix[i][j] = matrix[height - i - 1][j];
			}
		}
		return n;
	}
	
	/**
	 * rotateLeft
	 * This will rotate the matrix to the left.
	 * @return This will return a Matrix value.  
	 * (Ie. If you have a given matrix and rotate it using the function it will return it,
	 * but not make the current matrix rotate) 
	 */
	public Matrix rotateLeft() {
		Matrix n = new Matrix(this.toString(), width, height);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				n.matrix[j][i] = matrix[i][width - j - 1];
			}
		}	
		return n;
	}
	
	/**
	 * rotateRight
	 * This will rotate the matrix to the right.
	 * @return This will return a Matrix value.  
	 * (Ie. If you have a given matrix and rotate it using the function it will return it,
	 * but not make the current matrix rotate) 
	 */
	public Matrix rotateRight() {
		Matrix n = new Matrix(this.toString(), this.width, this.height);
		
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				n.matrix[j][i] = matrix[this.height - i - 1][j];
			}
		}
		
		return n;
	}
	
	/**
	 * multipleMatrix
	 * This will multiply two Matrices together.  This will only work if they are matrices that can be multiplied together.
	 * @param m - Matrix that you want to multiply with.
	 * @return Matrix - this will return a new Matrix as a result.
	 * Ex.
	 * 1,2,3   1,2,3    30,36,42,
	 * 4,5,6 * 4,5,6 -> 66,81,96, 
	 * 7,8,9   7,8,9    102,126,150
	 */
	public Matrix multiplyMatrix(Matrix m) {
		Matrix n = new Matrix(this.toString(), this.width, this.height);
		// They are Square matrices - WORKS
		if (m.height == m.width && this.height == this.width && this.height == m.height){
			for (int i = 0; i < this.height; i++) {
				for (int j = 0; j < this.width; j++) {
					n.matrix[i][j] = matrix[i][0] * m.matrix[0][j];
					for (int x = (this.width-1); x > 0; x--) {
						n.matrix[i][j] += matrix[i][x] * m.matrix[x][j];
					}
				}
			}
		}
		// 1x3 * 3x1 - WORKS
		else if (this.height == 1 && this.width != 1) {
			n = new Matrix(1, m.width, 100);
			for (int i = 0; i < m.width; i++) {
				for (int j = 0; j < this.height; j++) {
					n.matrix[0][i] = matrix[0][j] * m.matrix[0][i];
					for (int x = (m.height - 1); x > 0; x--) {
						n.matrix[0][i] += matrix[0][x] * m.matrix[x][i];
					}
				}
			}
		}
		// 3x1 * 1x3. Where 3 is the height.
		else if (m.height != 1 && m.width == 1) {
			n = new Matrix(m.height, 1, 100);
			for (int i = 0; i < this.height; i++) {
				for (int j = 0; j < 1; j++) {
					n.matrix[i][j] = matrix[i][0] * m.matrix[0][0];
						for (int x = (this.height - 1); x > 0; x--) {
						n.matrix[i][j] += matrix[i][x] * m.matrix[x][0];
					}
				}
			}
		}
		// For odd matrices.  Like multiplying a 3x2 * 2x2. Where 3 is the height.
		else if (m.height == this.width) {
			for (int i = 0; i < this.height; i++) {
				for (int j = 0; j < m.width; j++) {
					n.matrix[i][j] = matrix[i][0] * m.matrix[0][j];
					if (m.height > 1) {
						for (int x = (m.height - 1); x > 0; x--) {
							n.matrix[i][j] += matrix[i][x] * m.matrix[x][j];
						}
					}
				}
			}
		}
		else {
			try {
				throw new Exception("Cannot multiply these Matrices together.");
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			
		}
		
		return n;
	}
	
	/**
	 * Multiply
	 * This will multiply a given matrix by a given number and return a new matrix as the result.
	 * @param num - The number to multiply the matrix by.
	 * @return Matrix - this Matrix will be the matrix provided multipled by the num.
	 * Ex. multiply(2)
	 * 1,2,3    1,4,6
	 * 4,5,6 -> 8,10,12
	 * 7,8,9    14,16,18
	 */
	public Matrix multiply(int num) {
		Matrix n = new Matrix(this.toString(), this.width, this.height);
		
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				n.matrix[i][j] = (matrix[i][j] * num);
			}
		}
		
		return n;
	}
	
	/**
	 * toString
	 * This will print out the Matrix so that it is more readable.
	 * Note: This will not add '{' where needed.  It simply adds commas between values.
	 * (Ex. {{1,2},{3,4}} would print out as:
	 * 1,2,
	 * 3,4
	 * 
	 */
	public String toString() {
		String temp = "";
		for (int i = 0; i < height; i++) {
			temp += "";
			for (int j = 0; j < width; j++) {
				if (((j+1) + (i+1)) == (width + height)) {
					temp += matrix[i][j];
				} else {
					temp += matrix[i][j] + ",";
				}
			}
			temp += "\n";
		}
		return temp;
	}

}

