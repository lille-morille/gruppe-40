package no.ntnu.idi.stud.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import no.ntnu.idi.stud.model.ChaosCanvas;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.dispatch.Observer;

public class ChaosGameCanvas extends Canvas implements Observer<ChaosGame>  {
  final double width;
  final double height;

  public ChaosGameCanvas(double v, double v1) {
    super(v, v1);
    this.width = v;
    this.height = v1;
  }

  private void drawPixels(ChaosCanvas canvas) {
    // Get context for drawing on the canvas
    GraphicsContext gc = this.getGraphicsContext2D();

    // Clear before redraw to override
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    gc.setFill(javafx.scene.paint.Color.BLACK);

    // Paint each pixel in black
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
  public void onNotified(ChaosGame game) {
    drawPixels(game.getCanvas());
  }
}
