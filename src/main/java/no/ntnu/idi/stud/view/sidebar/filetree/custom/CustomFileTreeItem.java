package no.ntnu.idi.stud.view.sidebar.filetree.custom;

import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import no.ntnu.idi.stud.view.button.IconButton;

public class CustomFileTreeItem extends TreeItem<String> {
  private final CustomFileTreeController controller;

  public CustomFileTreeItem(String name, CustomFileTreeController controller) {
    super(name);
    this.controller = controller;

    IconButton iconButton = new IconButton("trash", this::onClick);
    this.setGraphic(iconButton);
  }

  private void onClick(MouseEvent event) {
    controller.onDeleteDescription(super.getValue());
  }
}
