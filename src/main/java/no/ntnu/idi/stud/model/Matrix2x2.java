package no.ntnu.idi.stud.model;

import no.ntnu.idi.stud.dispatch.Observable;
import no.ntnu.idi.stud.serialization.Serializable;

/**
 * A class representing a 2x2 matrix.
 */
public class Matrix2x2 extends Observable<Matrix2x2> implements Serializable {
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
   * Gets the value a00 of the matrix
   *
   * @return a00
   */
  public double getA00() {
    return a00;
  }

  /**
   * Gets the value a00 of the matrix
   *
   * @return a01
   */
  public double getA01() {
    return a01;
  }

  /**
   * Gets the value a00 of the matrix
   *
   * @return a10
   */
  public double getA10() {
    return a10;
  }

  /**
   * Gets the value a00 of the matrix
   *
   * @return a11
   */
  public double getA11() {
    return a11;
  }

  public void setA00(double a00) {
    this.a00 = a00;
    notifyObservers(this);
  }

  public void setA01(double a01) {
    this.a01 = a01;
    notifyObservers(this);
  }

  public void setA10(double a10) {
    this.a10 = a10;
    notifyObservers(this);
  }

  public void setA11(double a11) {
    this.a11 = a11;
    notifyObservers(this);
  }

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

  public static Matrix2x2 fromString(String s) {
    String[] parts = s.split(",");
    return new Matrix2x2(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]),
        Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
  }


  /**
   * Get the first row and first column of the matrix
   *
   * @return The first row and first column of the matrix
   */
  public Vector2D multiply(Vector2D b) {
    return new Vector2D(a00 * b.getX0() + a01 * b.getX1(), a10 * b.getX0() + a11 * b.getX1());
  }

  @Override
  public String toString() {
    return String.format("Matrix [[%s, %s], [%s, %s]]", a00, a01, a10, a11);
  }

  @Override
  public String toSerializedString() {
    return String.format("%s,%s,%s,%s", a00, a01, a10, a11);
  }
}
