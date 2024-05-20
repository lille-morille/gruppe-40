package no.ntnu.idi.stud.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.ChaosCanvas;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.Vector2D;

/**
 * A canvas that draws a chaos game.
 */
public class ChaosGameCanvas extends Canvas implements Observer<ChaosGame> {
  /**
   * Create a canvas using the given width and height.
   *
   * @param width The width of the canvas
   * @param height The height of the canvas
   */
  public ChaosGameCanvas(double width, double height) {
    super(width, height);
  }

  /**
   * Draw the pixels of the canvas on this canvas.
   *
   * @param canvas The canvas to draw
   */
  public void drawPixels(ChaosCanvas canvas) {
    // Get context for drawing on the canvas
    GraphicsContext gc = this.getGraphicsContext2D();

    // Clear before redraw to override
    gc.clearRect(0, 0, getWidth(), getHeight());
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
