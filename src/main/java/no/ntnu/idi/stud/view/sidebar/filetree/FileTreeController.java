package no.ntnu.idi.stud.view.sidebar.filetree;

import java.io.IOException;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;
import no.ntnu.idi.stud.view.Toast;
import no.ntnu.idi.stud.view.dialog.confirmDialog.ConfirmDialogBuilder;
import no.ntnu.idi.stud.view.dialog.textInputDialog.TextInputDialogBuilder;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeModel;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeView;
import no.ntnu.idi.stud.view.sidebar.filetree.templates.TemplatesFileTreeView;

/**
 * Controller for the custom file tree
 */
public class FileTreeController {
  private final CustomFileTreeModel model;
  private final ChaosGameFileHandler fileHandler;

  /**
   * Construct the controller. Sets up the model and file handler.
   */
  public FileTreeController() {
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
    new TextInputDialogBuilder().setPrompt("Please enter the name of the new chaos game")
        .setConfirmButtonText("Create").setCancelButtonText("Cancel")
        .setOnSubmit(this::handleCreateDescription).createTextInputDialog().show();
  }

  /**
   * Handle the creation of a new description
   *
   * @param value The name of the new description
   */
  private void handleCreateDescription(String value) {
    model.createDescription(value);
  }


  public void onDeleteDescription(String name) {
    new ConfirmDialogBuilder().setOnConfirm(() -> handleDeleteDescription(name))
        .setPrompt("Are you sure you want to delete this chaos game?")
        .setConfirmButtonText("Delete").setCancelButtonText("Cancel").createConfirmDialog().show();
  }

  /**
   * On click delete description
   *
   * @param name The name of the description to delete
   */
  private void handleDeleteDescription(String name) {
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
    if(description == null) {
      return;
    }
    try {
      fileHandler.writeToFile(description, name);
    } catch (IOException e) {
      new Toast("Failed to save game", Toast.Variant.ERROR).show();
    }
  }

  /**
   * On click select game
   *
   * @param name The name of the game to select
   */
  public void onSelectGame(String name) {
    // Avoid selecting categories or other
    if (isGameInvalid(name)) {
      return;
    }
    model.setSelectedDescription(name);
  }

  private boolean isGameInvalid(String name) {
    if (name == null) {
      return true;
    }

    return name.equals(CustomFileTreeView.name) || name.equals(TemplatesFileTreeView.name);
  }

  /**
   * Whether a game is selected in the file tree
   *
   * @param name The name of the game
   * @return Whether the game is selected
   */
  public boolean getIsGameSelected(String name) {
    String selectedDescription = model.getSelectedDescription();
    if (isGameInvalid(selectedDescription)) {
      return false;
    }
    return selectedDescription.equals(name);
  }
}
