package no.ntnu.idi.stud.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests the Vector2D class
 */
class Vector2DTest {
  @Test
  @DisplayName("Test the toString() method")
  void testToString() {
    Vector2D vector = new Vector2D(1, 2);
    assertEquals("Vector [1.0, 2.0]", vector.toString());
  }

  /**
   * Tests the constructor
   */
  @Test
  @DisplayName("Tests the constructor")
  void constructorVector2DParam() {
    Vector2D vector = new Vector2D(1, 2);
    assertEquals(vector.getX0(), 1);
    assertEquals(vector.getX1(), 2);
  }

  /**
   * Tests for the add method
   */
  @Nested
  @DisplayName("add method tests")
  class AddTests {
    /**
     * Tests the add method with test case 1
     */
    @Test
    @DisplayName("Test add, case 1")
    void add() {
      Vector2D vector = new Vector2D(1, 2);
      Vector2D other = new Vector2D(3, 4);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(4, 6);
      assertEquals(addResult, result);
    }

    /**
     * Tests the add method with test case 2
     */
    @Test
    @DisplayName("Test add, case 2")
    void add1() {
      Vector2D vector = new Vector2D(19, 23);
      Vector2D other = new Vector2D(34, 55);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(53, 78);
      assertEquals(addResult, result);
    }

    /**
     * Tests the add method with test case 3
     */
    @Test
    @DisplayName("Test add, case 3")
    void add2() {
      Vector2D vector = new Vector2D(233, 498);
      Vector2D other = new Vector2D(340, 550);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(573, 1048);
      assertEquals(addResult, result);
    }
  }

  /**
   * Tests for the subtract method
   */
  @Nested
  @DisplayName("subtract method tests")
  class SubtractTest {
    /**
     * Tests the subtract method with test case 1
     */
    @Test
    @DisplayName("Test subtract, case 1")
    void subtract() {
      Vector2D vector = new Vector2D(3, 4);
      Vector2D other = new Vector2D(1, 2);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(2, 2);
      assertEquals(subtractResult, result);
    }

    /**
     * Tests the subtract method with test case 2
     */
    @Test
    @DisplayName("Test subtract, case 2")
    void subtract1() {
      Vector2D vector = new Vector2D(23, 40);
      Vector2D other = new Vector2D(32, 103);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(-9, -63);
      assertEquals(subtractResult, result);
    }

    /**
     * Tests the subtract method with test case 2
     */
    @Test
    @DisplayName("Test subtract, case 2")
    void subtract2() {
      Vector2D vector = new Vector2D(536, 803);
      Vector2D other = new Vector2D(459, 901);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(77, -98);
      assertEquals(subtractResult, result);
    }
  }
}
