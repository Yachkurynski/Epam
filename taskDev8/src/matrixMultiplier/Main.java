package matrixMultiplier;

/**
 * Multiplies matrices.
 */
public class Main {
  private static final String MULTIPLY_ERROR_MSG = "Can't multiply matrices.";

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   */
  public static void main(String[] args) {
    MatrixMultiplier matrixMultiplier = new MatrixMultiplier();
    MatrixFiller matrixFiller = new MatrixFiller();
    PrintResults printer = new PrintResults();

    try {
      double matrixA[][] = matrixFiller.fillMatrix();
      double matrixB[][] = matrixFiller.fillMatrix();
      double resultMatrix[][] = matrixMultiplier.multiplyMatrix(matrixA, matrixB);

      printer.printMatrix(resultMatrix);
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println(MULTIPLY_ERROR_MSG);
    }
  }
}
