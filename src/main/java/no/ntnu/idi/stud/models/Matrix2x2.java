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
  public Vector2D multiply(Vector2D b) {
    return new Vector2D(a00 * b.getX0() + a01 * b.getX1(), a10 * b.getX0() + a11 * b.getX1());
  }
}
