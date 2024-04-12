package no.ntnu.idi.stud;

import no.ntnu.idi.stud.model.Vector2D;

/**
 * Assists testing classes with common utility functions
 * <p>
 * Certain testing tasks are repetitive and require a bit more logic to be executed.
 * This class helps out in these situations.
 */
public class TestHelper {
  /**
   * Asserts that two vectors are approximately equal.
   * <p>
   * This is important because floating point precision errors might cause assertion errors to be
   * thrown while the result was perfectly valid in the test case.
   * The error threshold is set to 0.001
   * @param expected The expected vector result
   * @param actual The vector returned by the function that is being tested
   */
  public static void assertApproximateVectors(Vector2D expected, Vector2D actual) {
    double diffX0 = Math.abs(expected.getX0() - actual.getX0());
    double diffX1 = Math.abs(expected.getX1() - actual.getX1());

    double threshold = 0.001;

    assert diffX0 < threshold && diffX1 < threshold
        : String.format("Expected %s, got %s. Diff x0: %s, x1: %s", expected, actual, diffX0, diffX1);
  }
}
