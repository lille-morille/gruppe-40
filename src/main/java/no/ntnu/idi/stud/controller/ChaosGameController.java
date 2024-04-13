package no.ntnu.idi.stud.controller;

import java.io.IOException;
import java.util.List;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.SavedGames;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;

public class ChaosGameController implements ChaosGameEventHandler {
  private final ChaosGame game;
  private final ChaosGameFileHandler fileHandler;
  private final int width;
  private final int height;
  String filePath;
  private final SavedGames savedGames;

  public ChaosGame getGame() {
    return game;
  }

  public ChaosGameController(int width, int height) {
    var description = ChaosGameDescription.empty();
    this.game = new ChaosGame(description, width, height);
    this.filePath = "";
    this.fileHandler = new ChaosGameFileHandler();
    this.width = width;
    this.height = height;
    this.savedGames = new SavedGames();
  }

  public void initialize() {
    savedGames.setSavedGames(fileHandler.getSavedGames());
  }


  public SavedGames getSavedGames() {
    return savedGames;
  }

  @Override
  public void handleCreateGame() {
    ChaosGameDescription description = ChaosGameDescription.empty();
    game.setDescription(description);
  }

  @Override
  public void handleLoadGameFromFile() {
    try {
      ChaosGameDescription description = fileHandler.readFromFile(filePath);
      game.setDescription(description);
      game.runSteps(1_000_000);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void handleFilePathChange(String newFilePath) {
    System.out.println("Changing to " + newFilePath);
    this.filePath = newFilePath;
  }

  @Override
  public void handleSaveGameToFile() {
    try {
      fileHandler.writeToFile(game.getDescription(), filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void handleStepCountChange(int newValue) {
    game.getCanvas().clear();
    game.runSteps(newValue);
  }

  @Override
  public void handleMinCoordXChange(int newValue) {

  }

  @Override
  public void handleMinCoordYChange(int newValue) {

  }

  @Override
  public void handleMaxCoordXChange(int newValue) {

  }

  @Override
  public void handleMaxCoordYChange(int newValue) {

  }

  @Override
  public void handleExitApp() {

  }

}
