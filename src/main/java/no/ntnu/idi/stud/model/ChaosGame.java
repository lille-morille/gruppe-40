package no.ntnu.idi.stud.model;

import java.util.Random;
import no.ntnu.idi.stud.dispatch.Observable;

public class ChaosGame extends Observable<ChaosGame> {
  private Random random;
  private ChaosCanvas chaosCanvas;
  private ChaosGameDescription description;
  private Vector2D currentPoint;

  public ChaosGame() { }

  public ChaosGame(ChaosGameDescription description, int width, int height, Vector2D minCoords,
                   Vector2D maxCoords) {
    this.chaosCanvas = new ChaosCanvas(width, height, minCoords, maxCoords);
    this.description = description;
    this.random = new Random();
    this.currentPoint = new Vector2D(0, 0);
  }

  public void setDescription(ChaosGameDescription description) {
    this.currentPoint = new Vector2D(0, 0);
    this.description = description;
    this.chaosCanvas.clear();
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
