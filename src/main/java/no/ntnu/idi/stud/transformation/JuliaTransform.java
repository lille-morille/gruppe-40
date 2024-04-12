package no.ntnu.idi.stud.transformation;

import no.ntnu.idi.stud.model.Complex;
import no.ntnu.idi.stud.model.Vector2D;

/**
 * A 2D Julia complex transformation.
 */
public class JuliaTransform extends Transform2D {
  /**
   * The transformation point.
   */
  private final Complex point;

  /**
   * The transformation sign.
   */
  private final int sign;

  /**
   * Creates a new Julia complex transformation.
   *
   * @param point the transformation point
   * @param sign  the transformation sign
   */
  public JuliaTransform(Complex point, int sign) {
    assert sign == -1 || sign == 1 : "Sign must be 1 or -1";

    this.point = point;
    this.sign = sign;
  }

  @Override
  public Vector2D transform(Vector2D point) {
    Vector2D subtractedRaw = point.subtract(this.point);
    Complex subtracted = new Complex(subtractedRaw.getX0(), subtractedRaw.getX1());
    Complex root = subtracted.sqrt();
    return new Complex(root.getX0() * sign, root.getX1() * sign);
  }

  @Override
  public String toSerializedString() {
    StringBuilder str = new StringBuilder();
    str.append(super.toSerializedString());

    str.append(point.toSerializedString());
    str.append(", ");
    str.append(sign);

    return str.toString();
  }
}
