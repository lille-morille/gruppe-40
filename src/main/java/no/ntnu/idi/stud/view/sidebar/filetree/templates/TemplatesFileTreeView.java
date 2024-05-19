package no.ntnu.idi.stud.view.sidebar.filetree.templates;

import javafx.scene.control.TreeItem;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.sidebar.filetree.FileTreeController;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeItem;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeModel;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class TemplatesFileTreeView extends TreeItem<String> implements Observer<CustomFileTreeModel> {
  FileTreeController controller;

  public static String name = "Templates";

  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public TemplatesFileTreeView(FileTreeController controller) {
    super(name, new Icon("book"));
    this.controller = controller;
  }

  static String[] templates =
      new String[] {"Sierpinski-triangle", "Julia-transformation", "Barnsley-transformation"};

  @Override
  public void onNotified(CustomFileTreeModel resource) {
    this.getChildren().clear();

    for (String template : templates) {
      TreeItem<String> item =
          new CustomFileTreeItem(template, controller, controller.getIsGameSelected(template),
              false);
      this.getChildren().add(item);
    }
  }
}
