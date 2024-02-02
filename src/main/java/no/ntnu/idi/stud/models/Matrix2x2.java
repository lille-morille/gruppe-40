package no.ntnu.idi.stud.models;

/**
 * A class representing a 2x2 matrix.
 */
public class Matrix2x2 {
  /**
   * The first row and first column of the matrix
   */
  private double a00;
  /**
   * The first row and second column of the matrix
   */
  private double a01;
  /**
   * The second row and first column of the matrix
   */
  private double a10;
  /**
   * The second row and second column of the matrix
   */
  private double a11;

  /**
   * Create a new 2x2 matrix.
   *
   * @param a00 The first row and first column of the matrix
   * @param a01 The first row and second column of the matrix
   * @param a10 The second row and first column of the matrix
   * @param a11 The second row and second column of the matrix
   */
  public Matrix2x2(double a00, double a01, double a10, double a11) {
    this.a00 = a00;
    this.a01 = a01;
    this.a10 = a10;
    this.a11 = a11;
  }

  /**
   * Get the first row and first column of the matrix
   *
   * @return The first row and first column of the matrix
   */
  public Matrix2x2 multiply(Matrix2x2 other) {
    return new Matrix2x2(
        a00 * other.a00 + a01 * other.a10,
        a00 * other.a01 + a01 * other.a11,
        a10 * other.a00 + a11 * other.a10,
        a10 * other.a01 + a11 * other.a11
    );
  }
}
