package no.ntnu.idi.stud.dispatch;

import no.ntnu.idi.stud.model.Matrix2x2;

/**
 * Handles changes to a matrix in a matrix editor.
 */
public interface MatrixHandler {
  /**
   * Handles the changes.
   *
   * @param matrix The new matrix returned by the matrix editor
   */
  void handleSetMatrix(Matrix2x2 matrix);
}
