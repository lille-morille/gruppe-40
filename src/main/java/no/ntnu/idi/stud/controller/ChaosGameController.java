package no.ntnu.idi.stud.controller;

import java.io.IOException;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.dispatch.ChaosGameListener;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;

public class ChaosGameController implements ChaosGameListener {
  private final ChaosGame game;

  public ChaosGame getGame() {
    return game;
  }

  public ChaosGameController(int width, int height) {
    var description = ChaosGameDescription.empty();
    this.game = new ChaosGame(description, width, height);
  }

  @Override
  public void onCreateGameClicked() {
    ChaosGameDescription description = ChaosGameDescription.empty();
    game.setDescription(description);
  }

  @Override
  public void onLoadGameFromFileClicked() {
    var path = "chaosgame.txt";
    ChaosGameFileHandler fileHandler = new ChaosGameFileHandler();

    try {
      ChaosGameDescription description = fileHandler.readFromFile(path);
      game.setDescription(description);
      game.runSteps(1_000_000);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
