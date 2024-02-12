package no.ntnu.idi.stud.transformations;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.models.Complex;
import no.ntnu.idi.stud.models.Vector2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests the JuliaTransform class
 */
class JuliaTransformTest {

  /**
   * Tests that the sign parameter of the constructor must be valid
   */
  @Test
  @DisplayName("Tests that the sign parameter of the constructor must be valid")
  void constructorSignParam() {
    Complex point = new Complex(1, 2);

    assertDoesNotThrow(
        () -> new JuliaTransform(point, 1),
        "Julia transform should work with sign 1"
    );

    assertDoesNotThrow(
        () -> new JuliaTransform(point, -1),
        "Julia transform should work with sign -1"
    );

    assertThrows(
        AssertionError.class,
        () -> new JuliaTransform(point, 0),
        "Julia transform should not work with sign 0"
    );

    assertThrows(
        AssertionError.class,
        () -> new JuliaTransform(point, -2),
        "Julia transform should not work with sign -2"
    );

    assertThrows(
        AssertionError.class,
        () -> new JuliaTransform(point, 2),
        "Julia transform should not work with sign 2"
    );
  }

  /**
   * Tests the transform method
   */
  @Test
  @DisplayName("Tests the transform method")
  void testTransformMethod() {
    Complex c = new Complex(0.3, 0.6);
    Complex z = new Complex(0.4, 0.2);

    JuliaTransform transform = new JuliaTransform(c, 1);

    Vector2D result = transform.transform(z);

    Vector2D correctResult = new Complex(0.506, -0.395);

    assert Math.abs(result.getX0() - correctResult.getX0()) < 0.01 &&
        Math.abs(result.getX1() - correctResult.getX1()) < 0.01 : "Wrong answer!";
  }
}
