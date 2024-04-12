package no.ntnu.idi.stud.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests the Complex class
 */
class ComplexTest {
  /**
   * Tests the toString() method of the class
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    Complex complex = new Complex(1, 2);
    assertEquals("Complex [1.0, 2.0]", complex.toString());
  }

  /**
   * Tests the constructor of the class
   */
  @Test
  @DisplayName("Tests the complex constructor")
  void constructor() {
    Complex complex = new Complex(1, 2);
    assertEquals(complex.getX0(), 1);
    assertEquals(complex.getX1(), 2);
  }

  /**
   * Tests the sqrt() method with multiple cases
   */
  @Nested
  @DisplayName("Square root method tests")
  class SqrtTest {
    /**
     * Tests the sqrt() method with test case 1
     */
    @Test
    @DisplayName("Test square, case 1")
    void sqrt() {
      Complex complex = new Complex(0.1, -0.4);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(0.509, -0.395);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }

    /**
     * Tests the sqrt() method with test case 2
     */
    @Test
    @DisplayName("Test square, case 2")
    void sqrt1() {
      Complex complex = new Complex(3, 4);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(2, 1);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }

    /**
     * Tests the sqrt() method with test case 3
     */
    @Test
    @DisplayName("Test square, case 3")
    void sqrt2() {
      Complex complex = new Complex(42, 56);
      Complex sqrtResult = complex.sqrt();
      Complex result = new Complex(7.483, 3.742);
      assert Math.abs(sqrtResult.getX0() - result.getX0()) < 0.01 &&
          Math.abs(sqrtResult.getX1() - result.getX1()) < 0.01 : "Wrong answer!";
    }
  }
}
