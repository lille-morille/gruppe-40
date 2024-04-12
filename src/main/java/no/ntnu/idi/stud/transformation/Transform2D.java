package no.ntnu.idi.stud.transformation;

import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.serialization.Serializable;

/**
 * A 2D transformation.
 */
public abstract class Transform2D implements Serializable {
  /**
   * Transforms a point or vector.
   *
   * @param point the point/vector to transform
   * @return the transformed point/vector
   */
  public abstract Vector2D transform(Vector2D point);
}
