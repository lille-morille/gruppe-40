package no.ntnu.idi.stud.view.sidebar.section.files;

import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.button.IconTextButton;
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

    VBox content = new VBox();

    // Trees
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
    content.getChildren().add(treeView);

    // Buttons

    HBox buttonGroup = new HBox(20);
    buttonGroup.setAlignment(Pos.CENTER);

    IconTextButton newFileButton =
        new IconTextButton("New File", "plus", this::handleNewFileClicked);
    IconTextButton saveButton =
        new IconTextButton("Save", "download", this::handleSaveClicked);

    buttonGroup.getChildren().addAll(newFileButton, saveButton);

    content.getChildren().add(buttonGroup);

    this.setContent(content);
  }

  void handleNewFileClicked(MouseEvent event) {

  }

  void handleSaveClicked(MouseEvent event) {

  }
}
