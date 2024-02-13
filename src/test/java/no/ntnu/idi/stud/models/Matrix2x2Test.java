package no.ntnu.idi.stud.models;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.transformations.JuliaTransform;
import org.junit.jupiter.api.*;

/**
 * Tests the Matrix2x2 class
 */
class Matrix2x2Test {

  /**
   * Tests the toString() method of the class
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
    assertEquals("Matrix [[1.0, 2.0], [3.0, 4.0]]", matrix.toString());
  }

  /**
   * Tests the constructor
   */
  @Test
  @DisplayName("Test for Matrix2x2 constructor")
  void constructorMatrix2x2Param() {
    Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);

    assertEquals(matrix.getA00(), 1);
    assertEquals(matrix.getA01(), 2);
    assertEquals(matrix.getA10(), 3);
    assertEquals(matrix.getA11(), 4);
  }

  /**
   * Tests for the multiply method
   */
  @Nested
  @DisplayName("Multiply method tests")
  class MultiplyTest {
    /**
     * Tests the multiply method with test case 1
     */
    @Test
    @DisplayName("Test multiply, case 1")
    void multiply() {
      Matrix2x2 A = new Matrix2x2(1, 2, 3, 4);
      Vector2D x = new Vector2D(5, 6);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(17, 39);
      assertEquals(multiplyResult, result);
    }

    /**
     * Tests the multiply method with test case 2
     */
    @Test
    @DisplayName("Test multiply, case 2")
    void multiply1() {
      Matrix2x2 A = new Matrix2x2(23, 15, 4, 72);
      Vector2D x = new Vector2D(9, 3);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(252, 252);
      assertEquals(multiplyResult, result);
    }

    /**
     * Tests the multiply method with test case 3
     */
    @Test
    @DisplayName("Test multiply, case 3")
    void multiply2() {
      Matrix2x2 A = new Matrix2x2(108, 230, 98, 326);
      Vector2D x = new Vector2D(63, 44);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(16924, 20518);
      assertEquals(multiplyResult, result);
    }
  }
}


