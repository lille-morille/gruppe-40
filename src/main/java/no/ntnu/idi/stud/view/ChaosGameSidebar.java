package no.ntnu.idi.stud.view;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.ChaosGameListener;

public class ChaosGameSidebar extends VBox {
  public ChaosGameSidebar(ChaosGameListener listener) {
    this.setPrefWidth(200);    // Set the width of the this

    Button createGameBtn = new Button("Create new game");
    createGameBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> listener.onCreateGameClicked());

    Button loadGameFromFileBtn = new Button("Load game from file");
    loadGameFromFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> listener.onLoadGameFromFileClicked());

    this.getChildren().addAll(createGameBtn, loadGameFromFileBtn);
  }
}
