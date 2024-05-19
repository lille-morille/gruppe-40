package no.ntnu.idi.stud.view.sidebar;

import javafx.scene.control.Accordion;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.view.sidebar.section.files.FilesSection;
import no.ntnu.idi.stud.view.sidebar.section.options.OptionsSection;
import no.ntnu.idi.stud.view.sidebar.section.transformations.TransformationsSection;

public class ChaosGameSidebar extends VBox {
  public ChaosGameSidebar() {
    this.setPrefWidth(300);    // Set the width of the this

    // Parent accordion
    final Accordion accordion = new Accordion();

    // Files section
    final FilesSection files = new FilesSection();

    final TransformationsSection transformations = new TransformationsSection();

    final OptionsSection options = new OptionsSection();

    accordion.getPanes().addAll(files, transformations, options);

    getChildren().add(accordion);



//    // Create game
//    Button createGameBtn = new Button("Create new game");
//    createGameBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
//        e -> controller.handleCreateGame());
//
//    // Show saved games
//    SavedGamesView savedGamesView = new SavedGamesView(controller);
//    controller.getSavedGames().addObserver(savedGamesView);
//
//    TextField saveFileField = new TextField();
//    saveFileField.setPromptText("Enter name to save");
//
//    // Save to file
//    Button saveGameToFileBtn = new Button("Save current game to file");
//    saveGameToFileBtn.addEventHandler(javafx.event.ActionEvent.ACTION,
//        e -> controller.handleSaveGameToFile(saveFileField.getText()));
//
//    // Step count
//    TextField stepCountField = new TextField();
//    stepCountField.setPromptText("Enter step count");
//    stepCountField.textProperty().addListener((observable, oldValue, newValue) -> {
//      controller.handleStepCountChange(Integer.parseInt(newValue));
//    });
//
//    // Min coord X
//    TextField minCoordXField = new TextField();
//    minCoordXField.setPromptText("Enter min coord X");
//
//    // Min coord Y
//    TextField minCoordYField = new TextField();
//    minCoordYField.setPromptText("Enter min coord Y");
//
//    // Max coord X
//    TextField maxCoordXField = new TextField();
//    maxCoordXField.setPromptText("Enter max coord X");
//
//    // Max coord Y
//    TextField maxCoordYField = new TextField();
//    maxCoordYField.setPromptText("Enter max coord Y");
//
//    // Min-max coords save button
//    Button saveMinMaxCoordsBtn = new Button("Save min-max coords");
//    saveMinMaxCoordsBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> {
//      controller.handleSaveMinMaxCoords(new Vector2D(Integer.parseInt(minCoordXField.getText()),
//              Integer.parseInt(minCoordYField.getText())),
//          new Vector2D(Integer.parseInt(maxCoordXField.getText()),
//              Integer.parseInt(maxCoordYField.getText())));
//    });
//
//    // Transformations
//    TransformationsEditor transformationsEditor = new TransformationsEditor(controller);
//    controller.getGame().addObserver(transformationsEditor);
//
//    // Exit app
//    Button exitAppBtn = new Button("Exit app");
//    exitAppBtn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> controller.handleExitApp());
//
//    this.setSpacing(10);
//    this.getChildren()
//        .addAll(createGameBtn, savedGamesView, saveFileField, saveGameToFileBtn, stepCountField,
//            minCoordXField, minCoordYField, maxCoordXField, maxCoordYField, transformationsEditor,
//            exitAppBtn);
  }
}