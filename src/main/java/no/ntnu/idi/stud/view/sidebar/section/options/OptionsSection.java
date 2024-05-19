package no.ntnu.idi.stud.view.sidebar.section.options;

import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.view.StyledComponent;

/**
 * Section for displaying and interacting with files.
 */
public class OptionsSection extends TitledPane implements StyledComponent {

  /**
   * Construct a new FilesSection.
   */
  public OptionsSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Options");

    VBox content = new VBox();

    // Trees
    TreeView<String> treeView = new TreeView<>();
    treeView.showRootProperty().set(false);

    TreeItem<String> rootItem = new TreeItem<>();

    treeView.setRoot(rootItem);
    content.getChildren().add(treeView);

    this.setContent(content);
  }
}
