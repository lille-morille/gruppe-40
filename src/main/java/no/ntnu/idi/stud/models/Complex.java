package no.ntnu.idi.stud.models;

/**
 * A class representing complex numbers and their operations.
 */
public class Complex extends Vector2D {

  /**
    * Constructs a new complex number with the given real and imaginary parts.
   */
  public Complex(double realPart, double imaginaryPart) {
    super(realPart, imaginaryPart);
  }

  public static Complex fromString(String s) {
    String[] parts = s.split(",");
    return new Complex(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
  }

  /**
   * Returns the complex conjugate of this complex number.
   * @return the complex conjugate of this complex numberk
   */
  public Complex sqrt() {
    double r = Math.sqrt(getX0() * getX0() + getX1() * getX1());
    double x0 = Math.sqrt((r + getX0()) / 2);
    double x1 = (Math.sqrt((r - getX0()) / 2)) * Math.signum(getX1());
    return new Complex(x0, x1);
  }

  @Override
  public String toString() {
    return String.format("Complex [%s, %s]", getX0(), getX1());
  }
}
