package no.ntnu.idi.stud.transformation;

import java.util.Random;
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
   * The sign to use.
   * If 0, uses a random for each transform.
   */
  private final int sign;

  /**
   * Creates a new Julia complex transformation.
   *
   * @param point the transformation point
   */
  public JuliaTransform(Complex point) {
    this.point = point;
    this.sign = 0;
  }

  /**
   * Creates a julia transform using a point and a fixed sign.
   *
   * <p>Asserts that the sign is either 1 or -1.
   *
   * @param point The transformation point
   * @param sign  The sign, either 1 or -1
   */
  public JuliaTransform(Complex point, int sign) {
    assert sign == 1 || sign == -1;
    this.point = point;
    this.sign = sign;
  }

  @Override
  public Vector2D transform(Vector2D point) {
    Vector2D subtractedRaw = point.subtract(this.point);
    Complex subtracted = new Complex(subtractedRaw.getX0(), subtractedRaw.getX1());
    Complex root = subtracted.sqrt();

    int currentSign;
    if (this.sign != 0) {
      currentSign = this.sign;
    } else {
      currentSign = new Random().nextInt(2) == 0 ? 1 : -1;
    }

    return new Complex(root.getX0() * currentSign, root.getX1() * currentSign);
  }

  @Override
  public String toSerializedString() {
    return super.toSerializedString() + point.toSerializedString();
  }

  public Complex getComplex() {
    return point;
  }
}
