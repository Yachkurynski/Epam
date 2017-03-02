package matrixMultiplier;

/**
 * Prints result of calculations.
 */
public class PrintResults {
  private static final String SPACE_SYMB = " ";

  /**
   * Prints given matrix.
   * @param matrix matrix which need to print.
   */
  public void printMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + SPACE_SYMB);
      }
      System.out.println("");
    }
  }
}
