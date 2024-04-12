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
}
