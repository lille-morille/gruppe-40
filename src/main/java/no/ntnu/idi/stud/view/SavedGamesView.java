package no.ntnu.idi.stud.view;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;

public class SavedGamesView extends VBox implements Observer<List<String>> {
  ChaosGameController controller;

  public SavedGamesView(ChaosGameController controller) {
    super();
    this.controller = controller;
  }

  @Override
  public void onNotified(List<String> resource) {
    getChildren().clear();

    for (String game : resource) {
      var label = new Label(game);
      label.addEventHandler(
          javafx.scene.input.MouseEvent.MOUSE_CLICKED,
          event -> controller.handleLoadGameFromFile(game));
      getChildren().add(label);
    }
  }
}
