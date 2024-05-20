package no.ntnu.idi.stud.view.sidebar.section.options;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.StyledComponent;

/**
 * Section for displaying and interacting with files.
 */
public class OptionsSection extends TitledPane implements StyledComponent, Observer<ChaosGameController> {
  /**
   * Construct a new FilesSection.
   */
  public OptionsSection() {
    addStylesheet("sidebar/section/section");
    this.setText("Options");
  }

  @Override
  public void onNotified(ChaosGameController resource) {
    VBox content = new VBox();

    if (resource.getGame().getDescription() == null) {
      return;
    }

    System.out.println("Rendering options");

    var stepsSlider = new StepsSlider(false);
    var minMaxCoordsEditor = new MinMaxCoordsEditor();

    content.getChildren().addAll(stepsSlider, minMaxCoordsEditor);

    this.setContent(content);
  }
}
