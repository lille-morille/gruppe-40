package no.ntnu.idi.stud.transformations;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.models.Complex;
import no.ntnu.idi.stud.models.Vector2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import no.ntnu.idi.stud.TestHelper;

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
   * Tests the Julia transform method
   */
  @Test
  @DisplayName("Tests the Julia transform method")
  void testTransformMethod() {
    Complex c = new Complex(0.3, 0.6);
    Complex z = new Complex(0.4, 0.2);

    JuliaTransform transform = new JuliaTransform(c, 1);

    Vector2D result = transform.transform(z);

    Vector2D actual = new Complex(0.506, -0.395);

    TestHelper.assertApproximateVectors(actual, result);
  }

  /**
   * Tests the Julia transform method
   */
  @Test
  @DisplayName("Tests the Julia transform method")
  void testTransformMethod2() {
    Complex c = new Complex(6, -3);
    Complex z = new Complex(3, 2);

    JuliaTransform transform = new JuliaTransform(c, -1);

    Vector2D result = transform.transform(z);

    Vector2D expected = new Complex(-1.18974, -2.10130);

    TestHelper.assertApproximateVectors(expected, result);
  }

  /**
   * Tests the Julia transform method
   */
  @Test
  @DisplayName("Tests the Julia transform method")
  void testTransformMethod3() {
    Complex c = new Complex(4, 4.5);
    Complex z = new Complex(10, -8);

    JuliaTransform transform = new JuliaTransform(c, 1);

    Vector2D result = transform.transform(z);

    Vector2D expected = new Complex(3.1516, -1.9831);

    TestHelper.assertApproximateVectors(expected, result);
  }
}
