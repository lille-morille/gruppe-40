package no.ntnu.idi.stud.model;

import java.util.Random;
import no.ntnu.idi.stud.dispatch.Observable;

/**
 * A chaos game that generates a fractal by applying a set of transformations to a point.
 */
public class ChaosGame extends Observable<ChaosGame> {
  private Random random;
  private ChaosCanvas chaosCanvas;
  private ChaosGameDescription description;
  private Vector2D currentPoint;

  /**
   * Instantiates a new Chaos game without a description.
   *
   * <p>Used to start an empty chaos game when creating a new file or starting the application.
   */
  public ChaosGame() {
  }

  /**
   * Create a chaos game with a description and a canvas.
   *
   * @param description the description to use
   * @param width       the width of the canvas
   * @param height      the height of the canvas
   */
  public ChaosGame(ChaosGameDescription description, int width, int height) {
    this.chaosCanvas =
        new ChaosCanvas(width, height, description.getMinCoords(), description.getMaxCoords());
    this.description = description;
    this.random = new Random();
    this.currentPoint = new Vector2D(0, 0);
  }

  /**
   * Set the description of the chaos game.
   *
   * <p>When the description is set, the current point is reset to the origin, and the canvas is
   * re-created with the new description.
   *
   * @param description the description to use
   */
  public void setDescription(ChaosGameDescription description) {
    this.currentPoint = new Vector2D(0, 0);
    this.description = description;
    setChaosCanvas(
        new ChaosCanvas(chaosCanvas.getWidth(), chaosCanvas.getHeight(), description.getMinCoords(),
            description.getMaxCoords()));
    notifyObservers(this);
  }

  public void setChaosCanvas(ChaosCanvas chaosCanvas) {
    this.chaosCanvas = chaosCanvas;
  }

  public ChaosGameDescription getDescription() {
    return description;
  }

  public ChaosCanvas getCanvas() {
    return chaosCanvas;
  }

  /**
   * Run a set number of steps in the canvas to draw pixels.
   *
   * @param steps the number of steps to run
   */
  public void runSteps(int steps) {
    for (int i = 0; i < steps; i++) {
      var transform =
          description.getTransforms().get(random.nextInt(description.getTransforms().size()));

      currentPoint = transform.transform(currentPoint);
      chaosCanvas.putPixel(currentPoint);
    }
    notifyObservers(this);
  }
}
