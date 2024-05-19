package no.ntnu.idi.stud.view.sidebar.section.files;

import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.button.IconTextButton;
import no.ntnu.idi.stud.view.sidebar.filetree.FileTreeController;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeView;
import no.ntnu.idi.stud.view.sidebar.filetree.templates.TemplatesFileTreeView;

/**
 * Section for displaying and interacting with files.
 */
public class FilesSection extends TitledPane implements StyledComponent {
  FileTreeController fileTreeController;
  ChaosGameDescription currenDescription;
  String currentName;

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
    treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
      TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
      if (item != null) {
        fileTreeController.onSelectGame(item.getValue());
      }
    });

    TreeItem<String> rootItem = new TreeItem<>();

    fileTreeController = new FileTreeController();

    var templatesView = new TemplatesFileTreeView(fileTreeController);
    fileTreeController.getModel().addObserver(templatesView);
    var customView = new CustomFileTreeView(fileTreeController);
    fileTreeController.getModel().addObserver(customView);
    fileTreeController.init();

    rootItem.getChildren().addAll(templatesView, customView);
    treeView.setRoot(rootItem);
    content.getChildren().add(treeView);

    // Buttons

    HBox buttonGroup = new HBox(20);
    buttonGroup.setAlignment(Pos.CENTER);

    IconTextButton newFileButton =
        new IconTextButton("New File", "plus", this::handleNewFileClicked);
    IconTextButton saveButton = new IconTextButton("Save", "download", this::handleSaveClicked);

    buttonGroup.getChildren().addAll(newFileButton, saveButton);

    content.getChildren().add(buttonGroup);

    this.setContent(content);
  }

  void handleNewFileClicked(MouseEvent event) {
    fileTreeController.onCreateDescription();
  }

  void handleSaveClicked(MouseEvent event) {
    fileTreeController.onSaveDescription(currenDescription, currentName);
  }
}
