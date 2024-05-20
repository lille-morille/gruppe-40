package no.ntnu.idi.stud.dispatch;

import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;

/**
 * Describes all event listeners that need to be dispatched from the view to the controller.
 */
public interface ChaosGameEventHandler {
  /**
   * Called when the user clicks the "Create Game" button.
   */
  void handleCreateGame();

  /**
   * Called when the user clicks the "Load Game" button.
   */
  void handleLoadGameFromFile(String fileName);

  void handleSaveGameToFile(String fileName);

  void handleStepCountChange(int newValue);

  void handleExitApp();

  void handleDeleteGame(String game);

  void handleSetMatrix(int transformationIndex, Matrix2x2 matrix2x2);

  void handleSetVector(int transformationIndex, Vector2D vector2D);

  void handleSaveMinMaxCoords(Vector2D minCoords, Vector2D maxCoords);

  void handleSetMinCoords(Vector2D vector);

  void handleSetMaxCoords(Vector2D vector);

  void zoomOut();

  void zoomIn();
}
