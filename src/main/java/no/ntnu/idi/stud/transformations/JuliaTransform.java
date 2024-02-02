package no.ntnu.idi.stud.transformations;

import no.ntnu.idi.stud.models.Complex;
import no.ntnu.idi.stud.models.Vector2D;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A 2D Julia complex transformation.
 */
public class JuliaTransform extends Transform2D {
  /**
   * The transformation point.
   */
  private Complex point;

  /**
   * The transformation sign.
   */
  private int sign;

  /**
   * Creates a new Julia complex transformation.
   *
   * @param point the transformation point
   * @param sign  the transformation sign
   */
  public JuliaTransform(Complex point, int sign) {
    this.point = point;
    this.sign = sign;
  }

  @Override
  public Vector2D transform(Vector2D point) {
    throw new NotImplementedException();
  }
}
