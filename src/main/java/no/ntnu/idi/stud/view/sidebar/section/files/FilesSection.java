package no.ntnu.idi.stud.view.sidebar.section.files;

import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeController;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeView;
import no.ntnu.idi.stud.view.sidebar.filetree.templates.TemplatesFileTree;

/**
 * Section for displaying and interacting with files.
 */
public class FilesSection extends TitledPane implements StyledComponent {
  /**
   * Construct a new FilesSection.
   */
  public FilesSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Files");

    TreeView<String> treeView = new TreeView<>();
    treeView.showRootProperty().set(false);

    TreeItem<String> rootItem = new TreeItem<>();

    var templatesView = new TemplatesFileTree();

    var customFileTreeController = new CustomFileTreeController();
    var customView = new CustomFileTreeView(customFileTreeController);
    customFileTreeController.getModel().addObserver(customView);
    customFileTreeController.init();

    rootItem.getChildren().addAll(templatesView, customView);
    treeView.setRoot(rootItem);

    this.setContent(treeView);
  }
}
