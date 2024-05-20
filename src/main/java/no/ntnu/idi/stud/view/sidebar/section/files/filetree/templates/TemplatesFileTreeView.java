package no.ntnu.idi.stud.view.sidebar.section.files.filetree.templates;

import javafx.scene.control.TreeItem;
import no.ntnu.idi.stud.controller.ChaosGameFactory;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.FileTreeController;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom.CustomFileTreeItem;
import no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom.CustomFileTreeModel;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class TemplatesFileTreeView extends TreeItem<String>
    implements Observer<CustomFileTreeModel> {
  FileTreeController controller;

  public static String name = "Templates";

  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public TemplatesFileTreeView(FileTreeController controller) {
    super(name, new Icon("book"));
    this.controller = controller;
  }

  @Override
  public void onNotified(CustomFileTreeModel resource) {
    this.getChildren().clear();

    var templates = ChaosGameFactory.getTransformations().keySet().stream().toList();

    for (String template : templates) {
      TreeItem<String> item =
          new CustomFileTreeItem(template, controller, controller.getIsGameSelected(template),
              false);
      this.getChildren().add(item);
    }
  }
}
