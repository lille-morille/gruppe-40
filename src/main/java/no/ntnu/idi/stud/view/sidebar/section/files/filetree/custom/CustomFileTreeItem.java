package no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom;

import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.button.IconButton;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;

public class CustomFileTreeItem extends TreeItem<String> {
  private final FileTreeController controller;

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
