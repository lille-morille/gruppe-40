package no.ntnu.idi.stud.view;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.Observer;

public class SavedGamesView extends VBox implements Observer<List<String>> {
  public SavedGamesView() {
    super();
  }

  @Override
  public void onNotified(List<String> resource) {
    getChildren().clear();

    for (String game : resource) {
      var label = new Label(game);
      getChildren().add(label);
    }
  }
}
