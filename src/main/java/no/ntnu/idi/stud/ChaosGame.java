package no.ntnu.idi.stud;

import java.util.Random;
import no.ntnu.idi.stud.models.Vector2D;

public class ChaosGame {
  private final ChaosCanvas chaosCanvas;
  private final ChaosGameDescription description;
  private final Random random;
  private Vector2D currentPoint;

  public ChaosGame(ChaosGameDescription description, int width, int height) {
    Vector2D minCoords = new Vector2D(0, 0);
    Vector2D maxCoords = new Vector2D(1, 1);

    this.chaosCanvas = new ChaosCanvas(width, height, minCoords, maxCoords);
    this.description = description;
    this.random = new Random();
    this.currentPoint = new Vector2D(0, 0);
  }

  public ChaosCanvas getCanvas() {
    return chaosCanvas;
  }

  public void runSteps(int steps) {
    for (int i = 0; i < steps; i++) {
      var transform =
          description.getTransforms().get(random.nextInt(description.getTransforms().size()));

      currentPoint = transform.transform(currentPoint);
      chaosCanvas.putPixel(currentPoint);
    }
  }
}
