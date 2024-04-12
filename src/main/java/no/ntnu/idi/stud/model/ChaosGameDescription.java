package no.ntnu.idi.stud.model;

import java.util.List;
import no.ntnu.idi.stud.transformation.Transform2D;

/**
 * A class that describes a chaos game. It contains the minimum and maximum coordinates of the
 * game, as well as the transformations that are used to generate the fractal.
 */
public class ChaosGameDescription {
  /**
   * The minimum and maximum coordinates of the game.
   */
  private final Vector2D minCoords;

  /**
   * The maximum coordinates of the game.
   */
  private final Vector2D maxCoords;

  /**
   * The transformations that are used to generate the fractal.
   */
  private final List<Transform2D> transforms;

  /**
   * Create a new chaos game description.
   *
   * @param minCoords  The minimum coordinates of the game.
   * @param maxCoords  The maximum coordinates of the game.
   * @param transforms The transformations that are used to generate the fractal.
   */
  public ChaosGameDescription(Vector2D minCoords, Vector2D maxCoords,
                              List<Transform2D> transforms) {
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.transforms = transforms;
  }

  public static ChaosGameDescription empty() {
    return new ChaosGameDescription(new Vector2D(0, 0), new Vector2D(0, 0), List.of());
  }

  /**
   * Get the minimum coordinates of the game.
   *
   * @return The minimum coordinates of the game.
   */
  public Vector2D getMinCoords() {
    return minCoords;
  }

  /**
   * Get the maximum coordinates of the game.
   *
   * @return The maximum coordinates of the game.
   */
  public Vector2D getMaxCoords() {
    return maxCoords;
  }

  /**
   * Get the transformations that are used to generate the fractal.
   *
   * @return The transformations that are used to generate the fractal.
   */
  public List<Transform2D> getTransforms() {
    return transforms;
  }
}
