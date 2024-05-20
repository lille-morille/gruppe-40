package no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom;

import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.button.IconButton;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;

/**
 * A custom file tree item for viewing files.
 */
public class CustomFileTreeItem extends TreeItem<String> {
  private final FileTreeController controller;

  /**
   * Creates a custom file tree item.
   *
   * @param name The name of the file or item
   * @param controller The file tree controller for this item
   * @param isSelected Whether this item should be marked as selected (with a checkmark)
   * @param canDelete Whether this item can be deleted (shows a bin icon)
   */
  public CustomFileTreeItem(String name, FileTreeController controller, boolean isSelected,
                            boolean canDelete) {
    super(name);
    this.controller = controller;

    HBox content = new HBox(5);

    if (canDelete) {
      IconButton iconButton = new IconButton("trash", this::onDeleteClick);
      content.getChildren().add(iconButton);
    }

    if (isSelected) {
      content.getChildren().add(new Icon("check"));
    }

    this.setGraphic(content);
  }

  private void onDeleteClick(MouseEvent event) {
    controller.onDeleteDescription(super.getValue());
  }
}
