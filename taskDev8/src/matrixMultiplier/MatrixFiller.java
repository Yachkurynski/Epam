package matrixMultiplier;

import java.io.IOException;

/**
 * Fills the matrix.
 */
public class MatrixFiller {
  private static final String ENTER_LINES_ASK = "Enter amount of lines: ";
  private static final String ENTER_COLUMNS_ASK = "Enter amount of columns: ";
  private static final String ENTER_MATRIX_ELEMENT_ASK = "Enter m[%d][%d]: ";

  /**
   * Fills the matrix by double values.
   *
   * @return filled by double values matrix.
   */
  public double[][] fillMatrix() throws IOException {
    ConsoleReader reader = new ConsoleReader();

    System.out.println(ENTER_LINES_ASK);
    int lines = reader.readInt();
    System.out.println(ENTER_COLUMNS_ASK);
    int columns = reader.readInt();

    double[][] matrix = new double[lines][columns];

    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.printf(ENTER_MATRIX_ELEMENT_ASK, i, j);
        matrix[i][j] = reader.readDouble();
      }
    }
    return matrix;
  }

}
