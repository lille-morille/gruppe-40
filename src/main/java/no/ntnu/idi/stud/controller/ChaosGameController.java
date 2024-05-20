package no.ntnu.idi.stud.controller;

import java.io.IOException;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;
import no.ntnu.idi.stud.dispatch.Observable;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.SavedGames;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.view.Toast;

/**
 * Controls a chaos game application.
 */
public class ChaosGameController extends Observable<ChaosGameController>
    implements ChaosGameEventHandler {
  private final ChaosGameFileHandler fileHandler;
  private final SavedGames savedGames;
  private ChaosGame game;
  private int stepCount;

  /**
   * Get the current step count.
   *
   * @return the current step count
   */
  public int getStepCount() {
    return stepCount;
  }

  /**
   * Get the current chaos game.
   *
   * @return the current chaos game
   */
  public ChaosGame getGame() {
    return game;
  }

  /**
   * Create a new chaos game and notify observers.
   */
  public void createGame() {
    this.game = new ChaosGame();
    notifyObservers(this);
  }

  /**
   * Create a new chaos game using the given description
   *
   * <p>Creates a canvas with width and height 500 and runs the step count automatically
   * on that canvas.
   *
   * @param description The description to draw from
   */
  public void createGame(ChaosGameDescription description) {
    this.game = new ChaosGame(description, 500, 500);
    notifyObservers(this);
    game.setDescription(description);
    game.runSteps(stepCount);
  }

  /**
   * Create a new chaos game using the given description, width and height.
   *
   * @param description The description to draw from
   * @param width The width of the canvas
   * @param height The height of the canvas
   */
  public void createGame(ChaosGameDescription description, int width, int height) {
    this.game = new ChaosGame(description, width, height);
    notifyObservers(this);
    game.setDescription(description);
    game.runSteps(stepCount);
  }

  /**
   * Create a new chaos game controller.
   */
  public ChaosGameController() {
    this.game = new ChaosGame();
    this.fileHandler = new ChaosGameFileHandler();
    this.savedGames = new SavedGames();
  }

  /**
   * Initializes the controller.
   *
   * <p>Should be called after all observers are subscribed to changes.
   */
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
    createGame();
    ChaosGameDescription description = ChaosGameDescription.empty();
    game.setDescription(description);
    notifyObservers(this);
  }

  @Override
  public void handleLoadGameFromFile(String name) {
    try {
      ChaosGameDescription description = fileHandler.readFromFile(name);
      game.setDescription(description);
      reloadCanvas();
    } catch (IOException e) {
      new Toast("Failed to load game", Toast.Variant.ERROR).show();
    }
  }

  @Override
  public void handleSaveGameToFile(String name) {
    try {
      fileHandler.writeToFile(game.getDescription(), name);
      savedGames.addSavedGame(name);
    } catch (IOException e) {
      new Toast("Failed to save game", Toast.Variant.ERROR).show();
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
  public void handleSaveMinMaxCoords(Vector2D minCoords, Vector2D maxCoords) {
    var description = game.getDescription();
    description.setMinCoords(minCoords);
    description.setMaxCoords(maxCoords);
    reloadCanvas();
  }

  @Override
  public void handleSetMinCoords(Vector2D vector) {
    getGame().getDescription().setMinCoords(vector);
    getGame().setDescription(getGame().getDescription());
    reloadCanvas();
  }

  @Override
  public void handleSetMaxCoords(Vector2D vector) {
    getGame().getDescription().setMaxCoords(vector);
    getGame().setDescription(getGame().getDescription());
    reloadCanvas();
  }

  @Override
  public void zoomOut() {
    createGame(getGame().getDescription(), getGame().getCanvas().getWidth() - 100,
        getGame().getCanvas().getHeight() - 100);
  }

  @Override
  public void zoomIn() {
    createGame(getGame().getDescription(), getGame().getCanvas().getWidth() + 100,
        getGame().getCanvas().getHeight() + 100);
  }

  @Override
  public void handleStepCountChange(int newValue) {
    this.stepCount = newValue;
    reloadCanvas();
  }

  @Override
  public void handleExitApp() {
    System.exit(0);
  }
}
