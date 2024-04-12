package no.ntnu.idi.stud.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import no.ntnu.idi.stud.ChaosCanvas;
import no.ntnu.idi.stud.models.Vector2D;
import no.ntnu.idi.stud.observer.ChaosGameObserver;

public class ChaosGameCanvas extends Canvas implements ChaosGameObserver {
  final double width;
  final double height;

  public ChaosGameCanvas(double v, double v1) {
    super(v, v1);
    this.width = v;
    this.height = v1;
  }

  private void drawPixels(ChaosCanvas canvas) {
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.setFill(javafx.scene.paint.Color.BLACK);

    for (int j = 0; j < canvas.getHeight(); j++) {
      for (int i = 0; i < canvas.getWidth(); i++) {
        var pixel = canvas.getPixel(new Vector2D(i, j));
        if (pixel > 0) {
          gc.fillRect(i, j, 1, 1);
        }
      }
    }
  }

  @Override
  public void updateCanvas(ChaosCanvas canvas) {
    drawPixels(canvas);
  }
}
