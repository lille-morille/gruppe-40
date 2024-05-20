package no.ntnu.idi.stud.view.sidebar.section.transformations;

import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;

/**
 * Section for displaying and interacting with files.
 */
public class TransformationsSection extends TitledPane implements StyledComponent,
    Observer<ChaosGameController> {
  FileTreeController fileTreeController;
  ChaosGameDescription currenDescription;
  String currentName;

  /**
   * Construct a new FilesSection.
   */
  public TransformationsSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Transformations");

    onNotified(ChaosGameControllerSingleton.getInstance().controller);
  }

  @Override
  public void onNotified(ChaosGameController resource) {
    VBox content = new VBox();

    var editor = new TransformationsEditor(resource);
    resource.getGame().addObserver(editor);
    content.getChildren().add(editor);

    this.setContent(content);
  }
}
