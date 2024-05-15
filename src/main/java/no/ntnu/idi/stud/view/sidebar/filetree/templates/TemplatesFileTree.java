package no.ntnu.idi.stud.view.sidebar.filetree.templates;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.icon.Icon;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class TemplatesFileTree extends VBox implements StyledComponent {
  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public TemplatesFileTree() {
    super();
    addStylesheet("/sidebar/section/filetree");


    Icon bookIcon = new Icon("book");

    TreeItem<String> rootItem = new TreeItem<>("Templates", bookIcon);

    String[] templates = new String[] {"Sierpinski-triangle", "Julia-transformation",
        "Barnsley-transformation"};

    for (String template : templates) {
      TreeItem<String> item = new TreeItem<>(template);
      rootItem.getChildren().add(item);
    }

    TreeView<String> tree = new TreeView<>(rootItem);

    this.getChildren().add(tree);
  }
}
