package no.ntnu.idi.stud.view.sidebar.section.transformations;

import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.sidebar.filetree.FileTreeController;

/**
 * Section for displaying and interacting with files.
 */
public class TransformationsSection extends TitledPane implements StyledComponent {
  FileTreeController fileTreeController;
  ChaosGameDescription currenDescription;
  String currentName;

  /**
   * Construct a new FilesSection.
   */
  public TransformationsSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Transformations");

    VBox content = new VBox();

    content.getChildren()
        .add(new TransformationsEditor(ChaosGameControllerSingleton.getInstance().controller));

    this.setContent(content);
  }

  void handleNewFileClicked(MouseEvent event) {
    fileTreeController.onCreateDescription();
  }

  void handleSaveClicked(MouseEvent event) {
    fileTreeController.onSaveDescription(currenDescription, currentName);
  }
}
