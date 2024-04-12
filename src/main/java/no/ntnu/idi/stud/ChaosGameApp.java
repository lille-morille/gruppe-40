package no.ntnu.idi.stud;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idi.stud.models.Matrix2x2;
import no.ntnu.idi.stud.models.Vector2D;
import no.ntnu.idi.stud.transformations.AffineTransform2D;
import no.ntnu.idi.stud.transformations.Transform2D;

/**
 * Hello world!
 */
public class ChaosGameApp {
  public static void main(String[] args) {
    List<Transform2D> transforms = new ArrayList<>();
    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0, 0)));
    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0.25, 0.5)));
    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0.5, 0)));

    ChaosGame chaosGame =
        new ChaosGame(new ChaosGameDescription(new Vector2D(0, 0), new Vector2D(1, 1), transforms),
            30, 30);

    chaosGame.runSteps(10000);

    ChaosCanvas chaosCanvas = chaosGame.getCanvas();

    for (int j = chaosCanvas.getHeight() - 1; j >= 0; j--) {
      for (int i = 0; i < chaosCanvas.getWidth(); i++) {
        System.out.print(chaosCanvas.getPixel(new Vector2D(i, j)) > 0 ? "X" : " ");
      }
      System.out.println();
    }
  }
}
