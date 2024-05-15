package no.ntnu.idi.stud.view.sidebar.filetree.templates;

import javafx.scene.control.TreeItem;
import no.ntnu.idi.stud.view.Icon;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class TemplatesFileTree extends TreeItem<String> {
  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public TemplatesFileTree() {
    super("Templates", new Icon("book"));

    String[] templates = new String[] {"Sierpinski-triangle", "Julia-transformation",
        "Barnsley-transformation"};

    for (String template : templates) {
      TreeItem<String> item = new TreeItem<>(template);
      this.getChildren().add(item);
    }
  }
}
