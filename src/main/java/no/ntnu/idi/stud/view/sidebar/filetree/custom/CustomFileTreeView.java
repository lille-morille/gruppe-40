package no.ntnu.idi.stud.view.sidebar.filetree.custom;

import javafx.scene.control.TreeItem;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.view.Icon;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class CustomFileTreeView extends TreeItem<String>
    implements Observer<CustomFileTreeModel> {
  CustomFileTreeController controller;

  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public CustomFileTreeView(CustomFileTreeController controller) {
    super("Custom", new Icon("pen"));
    this.controller = controller;
  }

  @Override
  public void onNotified(CustomFileTreeModel model) {
    this.getChildren().clear();

    for (String template : model.getDescriptions()) {
      TreeItem<String> item = new CustomFileTreeItem(template, controller);
      getChildren().add(item);
    }
  }
}
