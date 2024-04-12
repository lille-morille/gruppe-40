package no.ntnu.idi.stud.controller;

import java.io.IOException;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;

public class ChaosGameController implements ChaosGameEventHandler {
  private final ChaosGame game;
  private final ChaosGameFileHandler fileHandler;
  String filePath;

  public ChaosGame getGame() {
    return game;
  }

  public ChaosGameController(int width, int height) {
    var description = ChaosGameDescription.empty();
    this.game = new ChaosGame(description, width, height);
    this.filePath = "";
    this.fileHandler = new ChaosGameFileHandler();
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
}
