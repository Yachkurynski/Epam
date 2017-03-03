package matrixMultiplier;

/**
 * Multiplies matrices.
 */
public class MatrixMultiplier {

  /**
   * Multiplies two given matrices.
   *
   * @param matrixA first matrix.
   * @param matrixB second matrix.
   * @return matrix which is result of multiplying two given matrices.
   * @throws ArrayIndexOutOfBoundsException when two matrices can't be multiplied.
   */
  public double[][] multiplyMatrix(double[][] matrixA, double[][] matrixB)
      throws ArrayIndexOutOfBoundsException {
    double resultMatrix[][] = new double[matrixA.length][matrixB[0].length];

    if (matrixA[0].length != matrixB.length) {
      throw new ArrayIndexOutOfBoundsException();
    }

    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixB[0].length; j++) {
        resultMatrix[i][j] = calculateNewMatrixElement(i, j, matrixA, matrixB);
      }
    }
    return resultMatrix;
  }

  /**
   * Calculate new element in result matrix.
   *
   * @param lineA number of line in first matrix (matrixA).
   * @param columnB number of column in second matrix (matrixB).
   * @param matrixA first matrix.
   * @param matrixB second matrix.
   * @return new element in result matrix.
   */
  private double calculateNewMatrixElement(int lineA, int columnB, double[][] matrixA,
      double[][] matrixB) {
    double resultElement = 0.0;

    for (int k = 0; k < matrixB.length; k++) {
      resultElement += matrixA[lineA][k] * matrixB[k][columnB];
    }
    return resultElement;
  }
}
