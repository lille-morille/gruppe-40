package no.ntnu.idi.stud.model;

import java.util.Objects;
import no.ntnu.idi.stud.dispatch.Observable;
import no.ntnu.idi.stud.serialization.Serializable;

/**
 * A class representing a 2D vector.
 */
public class Vector2D extends Observable<Vector2D> implements Serializable {
  /**
   * The first part of the vector.
   */
  private double x0;
  /**
   * The second part of the vector.
   */
  private double x1;

  /**
   * Create a new 2D vector.
   *
   * @param x0 The x part of the vector
   * @param x1 The y part of the vector
   */
  public Vector2D(double x0, double x1) {
    this.x0 = x0;
    this.x1 = x1;
  }

  /**
   * Construct a vector from a serialized string.
   *
   * @param str The string to use
   * @return The vector from the string
   */
  public static Vector2D fromString(String str) {
    String[] parts = str.split(",");
    return new Vector2D(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
  }

  public void setX0(double x0) {
    this.x0 = x0;
    notifyObservers(this);
  }

  public void setX1(double x1) {
    this.x1 = x1;
    notifyObservers(this);
  }

  /**
   * Get the x part of the vector.
   *
   * @return The x part of the vector
   */
  public double getX0() {
    return x0;
  }

  /**
   * Get the y part of the vector.
   *
   * @return The y part of the vector
   */
  public double getX1() {
    return x1;
  }

  /**
   * Add two vectors together.
   *
   * @param other The other vector to add
   * @return A new vector that is the sum of the two vectors
   */
  public Vector2D add(Vector2D other) {
    return new Vector2D(x0 + other.x0, x1 + other.x1);
  }

  /**
   * Subtract two vectors.
   *
   * @param other The other vector to subtract
   * @return A new vector that is the difference of the two vectors
   */
  public Vector2D subtract(Vector2D other) {
    return new Vector2D(x0 - other.x0, x1 - other.x1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vector2D vector2D = (Vector2D) o;
    return Double.compare(x0, vector2D.x0) == 0 && Double.compare(x1, vector2D.x1) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x0, x1);
  }

  @Override
  public String toString() {
    return String.format("Vector [%s, %s]", x0, x1);
  }

  @Override
  public String toSerializedString() {
    return String.format("%s,%s", getX0(), getX1());
  }
}
