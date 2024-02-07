package no.ntnu.idi.stud.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ComplexTest {
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    Complex complex = new Complex(1, 2);
    assertEquals("Complex [1.0, 2.0]", complex.toString());
  }

  @Nested
  @DisplayName("Tests the complex constructor")
  class ConstructorTest {
    @Test
    void constructor() {
      Complex complex = new Complex(1, 2);
      assertEquals(complex.getX0(), 1);
      assertEquals(complex.getX1(), 2);
    }
  }

  @Nested
  @DisplayName("Tests the square root method")
  class SqrtTest {
    @Test
    void sqrt() {
      Complex complex = new Complex(0.1, -0.4);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(0.509, -0.395);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }
    @Test
    void sqrt1() {
      Complex complex = new Complex(3, 4);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(2, 1);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }
    @Test
    void sqrt2() {
      Complex complex = new Complex(42, 56);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(7.483, 3.742);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }
  }
}
