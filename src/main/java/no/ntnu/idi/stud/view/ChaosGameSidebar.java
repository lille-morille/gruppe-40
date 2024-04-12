package no.ntnu.idi.stud.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;

public class ChaosGameSidebar extends VBox {
  public ChaosGameSidebar(ChaosGameEventHandler handler) {
    this.setPrefWidth(200);    // Set the width of the this

    Button createGameBtn = new Button("Create new game");
    createGameBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> handler.handleCreateGame());

    TextField fileField = new TextField();
    fileField.setPromptText("Enter file path");
    fileField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleFilePathChange(newValue);
    });

    Button loadGameFromFileBtn = new Button("Load game from file");
    loadGameFromFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> handler.handleLoadGameFromFile());

    Button saveGameToFileBtn = new Button("Save current game to file");
    saveGameToFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> handler.handleSaveGameToFile());

    this.getChildren().addAll(createGameBtn, fileField, loadGameFromFileBtn, saveGameToFileBtn);
  }
}
