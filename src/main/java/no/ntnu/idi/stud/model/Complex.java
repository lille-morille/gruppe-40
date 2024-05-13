package no.ntnu.idi.stud.model;

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
   * Returns the randomized complex conjugate of this complex number.
   *
   * @return the randomized complex conjugate of this complex number
   */
  public Complex sqrt() {
    double r = getX0();
    double i = getX1();

    double complexLength = Math.sqrt(r * r + i * i);

    double sqrtReal = Math.sqrt((complexLength + r) / 2);
    double sqrtImaginary = 0;

    if (i != 0) {
      sqrtImaginary = (i / Math.abs(i)) * Math.sqrt((complexLength - r) / 2);
    }

    return new Complex(sqrtReal, sqrtImaginary);
  }

  @Override
  public String toString() {
    return String.format("Complex [%s, %s]", getX0(), getX1());
  }
}
