package no.ntnu.idi.stud.view.sidebar;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.sidebar.section.files.FilesSection;
import no.ntnu.idi.stud.view.sidebar.section.options.OptionsSection;
import no.ntnu.idi.stud.view.sidebar.section.transformations.TransformationsSection;

/**
 * The sidebar view for the application.
 */
public class ChaosGameSidebar extends ScrollPane {
  /**
   * Creates a sidebar.
   */
  public ChaosGameSidebar() {
    this.setPrefWidth(250);    // Set the width of the this

    // Always show the vertical scrollbar
    this.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    // Parent accordion
    final VBox accordion = new VBox();

    // Files section
    final FilesSection files = new FilesSection();

    final TransformationsSection transformations = new TransformationsSection();
    ChaosGameControllerSingleton.getInstance().controller.addObserver(transformations);

    final OptionsSection options = new OptionsSection();
    ChaosGameControllerSingleton.getInstance().controller.addObserver(options);

    accordion.getChildren().addAll(files, transformations, options);

    setContent(accordion);

    // Bind the width of the Accordion to the width of the ScrollPane's viewport
    this.viewportBoundsProperty().addListener((observable, oldValue, newValue) -> {
      accordion.setMinWidth(newValue.getWidth());
      accordion.setPrefWidth(newValue.getWidth());
    });
  }
}
