package no.ntnu.idi.stud;

import java.io.IOException;
import no.ntnu.idi.stud.models.Vector2D;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;

/**
 * Hello world!
 */
public class ChaosGameApp {
  public static void main(String[] args) throws IOException {
//    List<Transform2D> transforms = new ArrayList<>();
//    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0, 0)));
//    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0.25, 0.5)));
//    transforms.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5), new Vector2D(0.5, 0)));
//
//    ChaosGameDescription description =
//        new ChaosGameDescription(new Vector2D(0, 0), new Vector2D(1, 1), transforms);

    var description = new ChaosGameFileHandler().readFromFile("chaosgame.txt");

    ChaosGame chaosGame = new ChaosGame(description, 30, 30);

    chaosGame.runSteps(10000);

    ChaosCanvas chaosCanvas = chaosGame.getCanvas();

    for (int j = chaosCanvas.getHeight() - 1; j >= 0; j--) {
      for (int i = 0; i < chaosCanvas.getWidth(); i++) {
        System.out.print(chaosCanvas.getPixel(new Vector2D(i, j)) > 0 ? "X" : " ");
      }
      System.out.println();
    }

    new ChaosGameFileHandler().writeToFile(description, "chaosgame.txt");
  }
}
