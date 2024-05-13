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
   * Creates a new Julia complex transformation.
   *
   * @param point the transformation point
   */
  public JuliaTransform(Complex point) {
    this.point = point;
  }

  @Override
  public Vector2D transform(Vector2D point) {
    Vector2D subtractedRaw = point.subtract(this.point);
    Complex subtracted = new Complex(subtractedRaw.getX0(), subtractedRaw.getX1());
    Complex root = subtracted.sqrt();
    final var sign = new Random().nextInt(0,2) == 0 ? 1 : -1;
    return new Complex(root.getX0() * sign, root.getX1() * sign);
  }

  @Override
  public String toSerializedString() {
    return super.toSerializedString() +
        point.toSerializedString();
  }

  public Complex getComplex() {
    return point;
  }
}
