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
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom.CustomFileTreeView;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.templates.TemplatesFileTreeView;

/**
 * Section for displaying and interacting with files.
 */
public class FilesSection extends TitledPane implements StyledComponent {
  FileTreeController fileTreeController;
  TreeItem<String> root;

  /**
   * Construct a new FilesSection.
   */
  public FilesSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Files");

    VBox content = new VBox();
    content.setFillWidth(true);

    // Trees
    TreeView<String> treeView = new TreeView<>();
    treeView.showRootProperty().set(false);
    treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
      TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
      if (item != null) {
        fileTreeController.onSelectGame(item.getValue());
      }
    });


    fileTreeController = new FileTreeController();

    var templatesView = new TemplatesFileTreeView(fileTreeController);
    fileTreeController.getModel().addObserver(templatesView);
    var customView = new CustomFileTreeView(fileTreeController);
    fileTreeController.getModel().addObserver(customView);
    fileTreeController.init();

    TreeItem<String> rootItem = new TreeItem<>();
    rootItem.getChildren().addAll(templatesView, customView);
    treeView.setRoot(rootItem);
    content.getChildren().add(treeView);
    this.root = rootItem;

    // Buttons
    HBox buttonGroup = new HBox(20);
    buttonGroup.setAlignment(Pos.CENTER);

    IconTextButton newFileButton =
        new IconTextButton("New File", "plus", this::handleNewFileClicked);
    IconTextButton saveButton = new IconTextButton("Save", "download", this::handleSaveClicked);

    buttonGroup.getChildren().addAll(newFileButton, saveButton);

    content.getChildren().add(buttonGroup);

    this.setContent(content);

    // Add listeners to adjust the TreeView height based on its content
    addHeightListener(rootItem);
    rootItem.getChildren().forEach(this::addHeightListener);

    // Initial height update
    updateTreeViewHeight();
  }

  private void addHeightListener(TreeItem<String> item) {
    item.expandedProperty().addListener((observable, oldValue, newValue) -> updateTreeViewHeight());
    item.getChildren().addListener(
        (javafx.collections.ListChangeListener.Change<? extends TreeItem<String>> c) -> {
          while (c.next()) {
            if (c.wasAdded()) {
              for (TreeItem<String> addedItem : c.getAddedSubList()) {
                addHeightListener(addedItem);
              }
            }
          }
          updateTreeViewHeight();
        });
  }

  private void updateTreeViewHeight() {
    double height = computeTreeViewHeight();
    this.setPrefHeight(height + 50); // Adding a little extra height for padding
  }

  private double computeTreeViewHeight() {
    return computeTreeItemHeight(root);
  }

  private double computeTreeItemHeight(TreeItem<String> item) {
    double height = 24; // Default height for a tree item
    if (item.isExpanded()) {
      for (TreeItem<String> child : item.getChildren()) {
        height += computeTreeItemHeight(child);
      }
    }
    return height;
  }

  void handleNewFileClicked(MouseEvent event) {
    fileTreeController.onCreateDescription();
  }

  void handleSaveClicked(MouseEvent event) {
    fileTreeController.onSaveDescription();
  }
}
