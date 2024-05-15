package no.ntnu.idi.stud.view.sidebar.filetree.templates;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.icon.Icon;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeController;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeModel;

/**
 * A tree-view showing all available chaos-game templates.
 */
public class CustomFileTreeView extends VBox
    implements StyledComponent, Observer<CustomFileTreeModel> {
  TreeItem<String> rootItem;
  CustomFileTreeController controller;

  /**
   * Creates a new tree-view showing all available chaos-game templates.
   */
  public CustomFileTreeView(CustomFileTreeController controller) {
    super();
    addStylesheet("/sidebar/section/filetree");

    Icon bookIcon = new Icon("pen");

    rootItem = new TreeItem<>("Custom", bookIcon);
  }

  @Override
  public void onNotified(CustomFileTreeModel model) {
    this.getChildren().clear();


    for (String template : model.getDescriptions()) {
      TreeItem<String> item = new TreeItem<>(template);
      rootItem.getChildren().add(item);
    }

    TreeView<String> tree = new TreeView<>(rootItem);

    this.getChildren().add(tree);
  }
}
