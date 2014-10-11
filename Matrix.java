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

