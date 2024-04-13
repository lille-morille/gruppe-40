package no.ntnu.idi.stud.view;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
      var box = new HBox();
      box.setSpacing(5);

      var label = new Label(game);

      var loadBtn = new Button("Load");
      loadBtn.addEventHandler(
          javafx.scene.input.MouseEvent.MOUSE_CLICKED,
          event -> controller.handleLoadGameFromFile(game));

      var deleteBtn = new Button("Delete");
      deleteBtn.addEventHandler(
          javafx.scene.input.MouseEvent.MOUSE_CLICKED,
          event -> controller.handleDeleteGame(game));

      box.getChildren().addAll(label, loadBtn, deleteBtn);
      getChildren().add(box);
    }
  }
}
