package no.ntnu.idi.stud.view.sidebar.section.files;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.sidebar.filetree.custom.CustomFileTreeController;
import no.ntnu.idi.stud.view.sidebar.filetree.templates.CustomFileTreeView;
import no.ntnu.idi.stud.view.sidebar.filetree.templates.TemplatesFileTree;

public class FilesSection extends TitledPane implements StyledComponent {
  public FilesSection() {
    addStylesheet("/sidebar/section/section");
    this.setText("Files");

    VBox content = new VBox();

    var templatesView = new TemplatesFileTree();

    var customFileTreeController = new CustomFileTreeController();
    var customView = new CustomFileTreeView(customFileTreeController);
    customFileTreeController.getModel().addObserver(customView);
    customFileTreeController.init();

    content.getChildren().addAll(templatesView, customView);

    this.setContent(content);
  }
}
