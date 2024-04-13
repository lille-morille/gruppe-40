package no.ntnu.idi.stud.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.view.transformations.TransformationsEditor;

public class ChaosGameSidebar extends VBox {
  public ChaosGameSidebar(ChaosGameController controller) {
    this.setPrefWidth(300);    // Set the width of the this

    // Create game
    Button createGameBtn = new Button("Create new game");
    createGameBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> controller.handleCreateGame());

    // Show saved games
    SavedGamesView savedGamesView = new SavedGamesView(controller);
    controller.getSavedGames().addObserver(savedGamesView);

    TextField saveFileField = new TextField();
    saveFileField.setPromptText("Enter name to save");

    // Save to file
    Button saveGameToFileBtn = new Button("Save current game to file");
    saveGameToFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> controller.handleSaveGameToFile(saveFileField.getText()));

    // Step count
    TextField stepCountField = new TextField();
    stepCountField.setPromptText("Enter step count");
    stepCountField.textProperty().addListener((observable, oldValue, newValue) -> {
      controller.handleStepCountChange(Integer.parseInt(newValue));
    });

    // Min coord X
    TextField minCoordXField = new TextField();
    minCoordXField.setPromptText("Enter min coord X");
    minCoordXField.textProperty().addListener((observable, oldValue, newValue) -> {
      controller.handleMinCoordXChange(Integer.parseInt(newValue));
    });

    // Min coord Y
    TextField minCoordYField = new TextField();
    minCoordYField.setPromptText("Enter min coord Y");
    minCoordYField.textProperty().addListener((observable, oldValue, newValue) -> {
      controller.handleMinCoordYChange(Integer.parseInt(newValue));
    });

    // Max coord X
    TextField maxCoordXField = new TextField();
    maxCoordXField.setPromptText("Enter max coord X");
    maxCoordXField.textProperty().addListener((observable, oldValue, newValue) -> {
      controller.handleMaxCoordXChange(Integer.parseInt(newValue));
    });

    // Max coord Y
    TextField maxCoordYField = new TextField();
    maxCoordYField.setPromptText("Enter max coord Y");
    maxCoordYField.textProperty().addListener((observable, oldValue, newValue) -> {
      controller.handleMaxCoordYChange(Integer.parseInt(newValue));
    });

    // Transformations
    TransformationsEditor transformationsEditor = new TransformationsEditor(controller);
    controller.getGame().addObserver(transformationsEditor);

    // Exit app
    Button exitAppBtn = new Button("Exit app");
    exitAppBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> controller.handleExitApp());

    this.setSpacing(10);
    this.getChildren()
        .addAll(createGameBtn, savedGamesView, saveFileField, saveGameToFileBtn,
            stepCountField, minCoordXField, minCoordYField, maxCoordXField, maxCoordYField,
            transformationsEditor,
            exitAppBtn);
  }
}
