package matrixMultiplier;

import java.io.IOException;

/**
 * Multiplies matrices.
 */
public class Main {

  private static final String MULTIPLY_ERROR_MSG = "Can't multiply matrices.";

  /**
   * Entry point to the program.
   *
   * @param args are not used.
   * @throws IOException when matrices can't be multiplied.
   */
  public static void main(String[] args) throws IOException {
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
    } catch (IOException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }
}
