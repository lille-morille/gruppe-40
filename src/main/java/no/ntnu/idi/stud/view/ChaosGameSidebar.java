package no.ntnu.idi.stud.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;

public class ChaosGameSidebar extends VBox {
  public ChaosGameSidebar(ChaosGameController handler) {
    this.setPrefWidth(200);    // Set the width of the this

    // Create game
    Button createGameBtn = new Button("Create new game");
    createGameBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> handler.handleCreateGame());

    // File path
    TextField fileField = new TextField();
    fileField.setPromptText("Enter file path");
    fileField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleFilePathChange(newValue);
    });

    // Load from file
    Button loadGameFromFileBtn = new Button("Load game from file");
    loadGameFromFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> handler.handleLoadGameFromFile());

    // Save to file
    Button saveGameToFileBtn = new Button("Save current game to file");
    saveGameToFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
        e -> handler.handleSaveGameToFile());

    // Show saved games
    SavedGamesView savedGamesView = new SavedGamesView();
    handler.getSavedGames().addObserver(savedGamesView);

    // Step count
    TextField stepCountField = new TextField();
    stepCountField.setPromptText("Enter step count");
    stepCountField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleStepCountChange(Integer.parseInt(newValue));
    });

    // Min coord X
    TextField minCoordXField = new TextField();
    minCoordXField.setPromptText("Enter min coord X");
    minCoordXField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleMinCoordXChange(Integer.parseInt(newValue));
    });

    // Min coord Y
    TextField minCoordYField = new TextField();
    minCoordYField.setPromptText("Enter min coord Y");
    minCoordYField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleMinCoordYChange(Integer.parseInt(newValue));
    });

    // Max coord X
    TextField maxCoordXField = new TextField();
    maxCoordXField.setPromptText("Enter max coord X");
    maxCoordXField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleMaxCoordXChange(Integer.parseInt(newValue));
    });

    // Max coord Y
    TextField maxCoordYField = new TextField();
    maxCoordYField.setPromptText("Enter max coord Y");
    maxCoordYField.textProperty().addListener((observable, oldValue, newValue) -> {
      handler.handleMaxCoordYChange(Integer.parseInt(newValue));
    });

    // Exit app
    Button exitAppBtn = new Button("Exit app");
    exitAppBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> handler.handleExitApp());

    this.getChildren()
        .addAll(createGameBtn, savedGamesView, fileField, loadGameFromFileBtn, saveGameToFileBtn,
            stepCountField, minCoordXField, minCoordYField, maxCoordXField, maxCoordYField,
            exitAppBtn);
  }
}
