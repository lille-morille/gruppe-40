package no.ntnu.idi.stud.view.icon;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon extends ImageView {
  /**
   * Creates an icon by name
   *
   * @param name The name of the file (without extension) in the resources directory
   */
  public Icon(String name) {
    super(new Image(
        Objects.requireNonNull(Icon.class.getResourceAsStream("/icons/" + name + ".png"))));
  }
}
