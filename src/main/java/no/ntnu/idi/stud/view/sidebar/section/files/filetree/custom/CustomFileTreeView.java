package no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom;

import javafx.scene.control.TreeItem;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class CustomFileTreeView extends TreeItem<String>
    implements Observer<CustomFileTreeModel> {
  FileTreeController controller;

  public static String name = "Custom";

  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public CustomFileTreeView(FileTreeController controller) {
    super(name, new Icon("pen"));
    this.controller = controller;
  }

  @Override
  public void onNotified(CustomFileTreeModel model) {
    this.getChildren().clear();

    for (String template : model.getDescriptions()) {
      boolean isSelected = controller.getIsGameSelected(template);
      TreeItem<String> item = new CustomFileTreeItem(template, controller, isSelected, true);
      getChildren().add(item);
    }
  }
}
