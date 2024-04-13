package no.ntnu.idi.stud.controller;

import java.io.IOException;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.SavedGames;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;

public class ChaosGameController implements ChaosGameEventHandler {
  private final ChaosGame game;
  private final ChaosGameFileHandler fileHandler;
  private final SavedGames savedGames;
  private int stepCount;

  public ChaosGame getGame() {
    return game;
  }

  public ChaosGameController(int width, int height) {
    var description = ChaosGameDescription.empty();
    this.game = new ChaosGame(description, width, height);
    this.fileHandler = new ChaosGameFileHandler();
    this.savedGames = new SavedGames();
  }

  public void initialize() {
    savedGames.setSavedGames(fileHandler.getSavedGames());
  }

  private void reloadCanvas() {
    game.getCanvas().clear();
    game.runSteps(stepCount);
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
  public void handleLoadGameFromFile(String name) {
    try {
      ChaosGameDescription description = fileHandler.readFromFile(name);
      game.setDescription(description);
      reloadCanvas();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void handleSaveGameToFile(String name) {
    try {
      fileHandler.writeToFile(game.getDescription(), name);
      savedGames.addSavedGame(name);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void handleDeleteGame(String game) {
    fileHandler.deleteFile(game);
    savedGames.removeSavedGame(game);
  }

  @Override
  public void handleSetMatrix(int transformationIndex, Matrix2x2 matrix2x2) {
    var transform = game.getDescription().getTransforms().get(transformationIndex);
    if (transform instanceof AffineTransform2D) {
      var matrix = ((AffineTransform2D) transform).getMatrix();
      matrix.setA00(matrix2x2.getA00());
      matrix.setA01(matrix2x2.getA01());
      matrix.setA10(matrix2x2.getA10());
      matrix.setA11(matrix2x2.getA11());
    }
    reloadCanvas();
  }

  @Override
  public void handleSetVector(int transformationIndex, Vector2D vector2D) {
    var transform = game.getDescription().getTransforms().get(transformationIndex);
    if (transform instanceof AffineTransform2D) {
      var vector = ((AffineTransform2D) transform).getVector();
      vector.setX0(vector2D.getX0());
      vector.setX1(vector2D.getX1());
    } else {
      var complex = ((JuliaTransform) transform).getComplex();
      complex.setX0(vector2D.getX0());
      complex.setX1(vector2D.getX1());
    }
    reloadCanvas();
  }

  @Override
  public void handleStepCountChange(int newValue) {
    this.stepCount = newValue;
    reloadCanvas();
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
    System.exit(0);
  }
}
