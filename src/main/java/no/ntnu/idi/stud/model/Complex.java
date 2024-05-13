package no.ntnu.idi.stud.model;

import java.util.Random;

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
   * @return the randomized complex conjugate of this complex number
   */
  public Complex sqrt() {
    double a = Math.pow(getX0(), 2) + Math.pow(getX1(), 2);
    int random = new Random().nextInt(2) == 0 ? 1 : -1;

    double r = random * Math.sqrt(0.5 * (Math.sqrt(a)) + getX0());
    double i = random * Math.signum(getX1()) * Math.sqrt(0.5 * (Math.sqrt(a) - getX0()));

    return new Complex(r, i);
  }

  @Override
  public String toString() {
    return String.format("Complex [%s, %s]", getX0(), getX1());
  }
}
