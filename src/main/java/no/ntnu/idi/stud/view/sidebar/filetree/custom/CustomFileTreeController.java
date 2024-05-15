package no.ntnu.idi.stud.view.sidebar.filetree.custom;

import java.io.IOException;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;
import no.ntnu.idi.stud.view.Toast;
import no.ntnu.idi.stud.view.dialog.textInputDialog.TextInputDialogBuilder;

/**
 * Controller for the custom file tree
 */
public class CustomFileTreeController {
  private final CustomFileTreeModel model;
  private final ChaosGameFileHandler fileHandler;

  /**
   * Construct the controller. Sets up the model and file handler.
   */
  public CustomFileTreeController() {
    model = new CustomFileTreeModel();
    fileHandler = new ChaosGameFileHandler();
  }

  /**
   * Initialize the controller. Load the saved games from file.
   */
  public void init() {
    // Load from file
    var games = fileHandler.getSavedGames();
    model.loadDescriptions(games);
  }

  /**
   * Get the model for the file tree.
   *
   * @return The model
   */
  public CustomFileTreeModel getModel() {
    return model;
  }

  /**
   * On click create description
   */
  public void onCreateDescription() {
    new TextInputDialogBuilder()
        .setPrompt("Please enter the name of the new chaos game")
        .setConfirmButtonText("Create")
        .setCancelButtonText("Cancel")
        .setOnSubmit(this::handleCreateDescription)
        .createTextInputDialog()
        .show();
  }

  /**
   * Handle the creation of a new description
   *
   * @param value The name of the new description
   */
  private void handleCreateDescription(String value) {
    model.createDescription(value);
  }

  /**
   * On click delete description
   *
   * @param name The name of the description to delete
   */
  public void onDeleteDescription(String name) {
    model.deleteDescription(name);
    fileHandler.deleteFile(name);
  }

  /**
   * On click save description
   *
   * @param description The description to save
   * @param name        The name of the description
   */
  public void onSaveDescription(ChaosGameDescription description, String name) {
    try {
      fileHandler.writeToFile(description, name);
    } catch (IOException e) {
      new Toast("Failed to save game", Toast.Variant.ERROR).show();
    }
  }
}
