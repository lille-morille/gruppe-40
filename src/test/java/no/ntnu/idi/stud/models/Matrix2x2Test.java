package no.ntnu.idi.stud.models;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.transformations.JuliaTransform;
import org.junit.jupiter.api.*;

class Matrix2x2Test {

  @Test
  @DisplayName("Test toString()")
  void testToString() {
    Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
    assertEquals("Matrix [[1.0, 2.0], [3.0, 4.0]]", matrix.toString());
  }

  @Nested
  @DisplayName("Test for Matrix2x2 constructor")
  class ConstructorTest {
    @Test
    void constructorMatrix2x2Param() {
      Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);

      assertEquals(matrix.getA00(), 1);
      assertEquals(matrix.getA01(), 2);
      assertEquals(matrix.getA10(), 3);
      assertEquals(matrix.getA11(), 4);
    }
  }

  @Nested
  @DisplayName("Tests the multiply method")
  class MultiplyTest{
    @Test
    void multiply() {
      Matrix2x2 A = new Matrix2x2(1, 2, 3, 4);
      Vector2D x = new Vector2D(5, 6);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(17, 39);
      assertEquals(multiplyResult, result);
    }

    @Test
    void multiply1() {
      Matrix2x2 A = new Matrix2x2(23, 15, 4, 72);
      Vector2D x = new Vector2D(9, 3);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(252, 252);
      assertEquals(multiplyResult, result);
    }

    @Test
    void multiply2() {
      Matrix2x2 A = new Matrix2x2(108, 230, 98, 326);
      Vector2D x = new Vector2D(63, 44);
      Vector2D multiplyResult = A.multiply(x);
      Vector2D result = new Vector2D(16924, 20518);
      assertEquals(multiplyResult, result);
    }
  }
}


