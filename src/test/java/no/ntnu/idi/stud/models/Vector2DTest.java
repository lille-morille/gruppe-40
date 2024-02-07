package no.ntnu.idi.stud.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Vector2DTest {
  @Test
  void testToString() {
    Vector2D vector = new Vector2D(1, 2);
    assertEquals("Vector [1.0, 2.0]", vector.toString());
  }

  @Nested
  @DisplayName("Tests Vector2D constructor")
  class ConstructorTest {
    @Test
    void constructorVector2DParam() {
      Vector2D vector = new Vector2D(1, 2);
      assertEquals(vector.getX0(), 1);
      assertEquals(vector.getX1(), 2);
    }
  }

  @Nested
  @DisplayName("Tests the add method")
  class AddTests{
    @Test
    void add() {
      Vector2D vector = new Vector2D(1, 2);
      Vector2D other = new Vector2D(3, 4);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(4, 6);
      assertEquals(addResult, result);
    }
    @Test
    void add1() {
      Vector2D vector = new Vector2D(19, 23);
      Vector2D other = new Vector2D(34, 55);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(53, 78);
      assertEquals(addResult, result);
    }
    @Test
    void add2() {
      Vector2D vector = new Vector2D(233, 498);
      Vector2D other = new Vector2D(340, 550);
      Vector2D addResult = vector.add(other);
      Vector2D result = new Vector2D(573, 1048);
      assertEquals(addResult, result);
    }
  }

  @Nested
  @DisplayName("Tests the subtract method ")
  class SubtractTest{
    @Test
    void subtract() {
      Vector2D vector = new Vector2D(3, 4);
      Vector2D other = new Vector2D(1, 2);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(2, 2);
      assertEquals(subtractResult, result);
    }
    @Test
    void subtract1() {
      Vector2D vector = new Vector2D(23, 40);
      Vector2D other = new Vector2D(32, 103);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(-9, -63);
      assertEquals(subtractResult, result);
    }
    @Test
    void subtract2() {
      Vector2D vector = new Vector2D(536, 803);
      Vector2D other = new Vector2D(459, 901);
      Vector2D subtractResult = vector.subtract(other);
      Vector2D result = new Vector2D(77, -98);
      assertEquals(subtractResult, result);
    }
  }
}
