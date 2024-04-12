package no.ntnu.idi.stud.transformation;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests the AffineTransform2D class
 */
class AffineTransform2DTest {
  /**
   * Tests the constructor
   */
  @Test
  @DisplayName("Test that the constructor works as expected")
  void testConstructor() {
    Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
    Vector2D vector = new Vector2D(1, 2);
    assertDoesNotThrow(() -> new AffineTransform2D(matrix, vector));
  }

  /**
   * Tests the transform function with different input
   */
  @Nested
  @DisplayName("Transform tests")
  class TransformTests {
    /**
     * Test the transform function with test input number 1
     */
    @Test
    @DisplayName("Test 1")
    void transform() {
      Matrix2x2 A = new Matrix2x2(1, 2, 3, 4);
      Vector2D b = new Vector2D(2, 1);
      Vector2D x = new Vector2D(2,1);
      AffineTransform2D affineTransform = new AffineTransform2D(A, b);
      Vector2D affineTransformResult = affineTransform.transform(x);
      Vector2D result = new Vector2D(6, 11);

      assertEquals(affineTransformResult, result);
    }

    /**
     * Test the transform function with test input number 2
     */
    @Test
    @DisplayName("Test 2")
    void tranform1() {
      Matrix2x2 A = new Matrix2x2(12, 98, 71, 3);
      Vector2D b = new Vector2D(23, 44);
      Vector2D x = new Vector2D(7,9);
      AffineTransform2D affineTransform = new AffineTransform2D(A, b);
      Vector2D affineTransformResult = affineTransform.transform(x);
      Vector2D result = new Vector2D(989, 568);

      assertEquals(affineTransformResult, result);
    }

    /**
     * Test the transform function with test input number 3
     */
    @Test
    @DisplayName("Test 3")
    void transform2() {
      Matrix2x2 A = new Matrix2x2(13, 17, 3, 8);
      Vector2D b = new Vector2D(5, 6);
      Vector2D x = new Vector2D(2,11);
      AffineTransform2D affineTransform = new AffineTransform2D(A, b);
      Vector2D affineTransformResult = affineTransform.transform(x);
      Vector2D result = new Vector2D(218, 100);

      assertEquals(affineTransformResult, result);
    }
  }
}

