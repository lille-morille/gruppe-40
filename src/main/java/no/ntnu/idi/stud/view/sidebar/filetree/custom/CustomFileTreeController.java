package no.ntnu.idi.stud.view.sidebar.filetree.custom;

import java.io.IOException;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.serialization.ChaosGameFileHandler;
import no.ntnu.idi.stud.view.Toast;
import no.ntnu.idi.stud.view.dialog.textInputDialog.TextInputDialogBuilder;

public class CustomFileTreeController {
  private final CustomFileTreeModel model;
  private final ChaosGameFileHandler fileHandler;

  public CustomFileTreeController() {
    model = new CustomFileTreeModel();
    fileHandler = new ChaosGameFileHandler();
  }

  public void init() {
    // Load from file
    var games = fileHandler.getSavedGames();
    model.loadDescriptions(games);
  }

  public CustomFileTreeModel getModel() {
    return model;
  }

  public void onCreateDescription() {
    new TextInputDialogBuilder()
        .setPrompt("Please enter the name of the new chaos game")
        .setConfirmButtonText("Create")
        .setCancelButtonText("Cancel")
        .setOnSubmit(this::handleCreateDescription)
        .createTextInputDialog()
        .show();
  }

  private void handleCreateDescription(String value) {
    model.createDescription(value);
  }

  public void deleteDescription(String name) {
    model.deleteDescription(name);
    fileHandler.deleteFile(name);
  }

  public void onSaveDescription(ChaosGameDescription description, String name) {
    try {
      fileHandler.writeToFile(description, name);
    } catch (IOException e) {
      new Toast("Failed to save game", Toast.Variant.ERROR).show();
    }
  }
}
