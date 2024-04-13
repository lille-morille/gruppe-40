package no.ntnu.idi.stud.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.ChaosGame;

public class TransformationsEditor extends VBox implements Observer<ChaosGame> {
  @Override
  public void onNotified(ChaosGame game) {
    getChildren().clear();

    var description = game.getDescription();

    for (var transformation : description.getTransforms()) {
      var label = new Label(transformation.getClass().getSimpleName());
      getChildren().add(label);
    }
  }
}
