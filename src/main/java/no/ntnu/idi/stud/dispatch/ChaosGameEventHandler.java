package no.ntnu.idi.stud.dispatch;

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
  void handleLoadGameFromFile();

  void handleFilePathChange(String newFilePath);

  void handleSaveGameToFile();

  void handleStepCountChange(int newValue);

  void handleMinCoordXChange(int newValue);

  void handleMinCoordYChange(int newValue);

  void handleMaxCoordXChange(int newValue);

  void handleMaxCoordYChange(int newValue);

  void handleExitApp();
}
