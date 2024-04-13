package no.ntnu.idi.stud.transformation;

import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;

/**
 * A 2D affine transformation.
 */
public class AffineTransform2D extends Transform2D {
  /**
   * The transformation matrix.
   */
  private Matrix2x2 matrix;

  /**
   * The vector to transform.
   */
  private Vector2D vector;

  /**
   * Creates a new affine transformation.
   *
   * @param matrix the transformation matrix
   * @param vector the vector to transform
   */
  public AffineTransform2D(Matrix2x2 matrix, Vector2D vector) {
    this.matrix = matrix;
    this.vector = vector;
  }

  public Matrix2x2 getMatrix() {
    return matrix;
  }

  public Vector2D getVector() {
    return vector;
  }

  @Override
  public Vector2D transform(Vector2D point) {
    return matrix.multiply(point).add(vector);
  }

  @Override
  public String toSerializedString() {
    StringBuilder str = new StringBuilder();
    str.append(super.toSerializedString());

    str.append(matrix.toSerializedString());
    str.append(", ");
    str.append(vector.toSerializedString());

    return str.toString();
  }
}
