package no.ntnu.idi.stud.transformations;

import no.ntnu.idi.stud.models.Vector2D;

/**
 * A 2D transformation.
 */
public abstract class Transform2D {
  /**
   * Transforms a point or vector.
   *
   * @param point the point/vector to transform
   * @return the transformed point/vector
   */
  public abstract Vector2D transform(Vector2D point);
}
