package no.ntnu.idi.stud.view;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.button.IconButton;

public class ChaosGameViewerZoomControls extends VBox implements StyledComponent {
  public ChaosGameViewerZoomControls() {
    super(5);
    getStyleClass().add("zoom-controls");

    var controller = ChaosGameControllerSingleton.getInstance().controller;

    var zoomInButton = new IconButton("zoom_plus", (event) -> controller.zoomIn());
    var zoomOutButton = new IconButton("zoom_minus", (event) -> controller.zoomOut());

    getChildren().addAll(zoomInButton, zoomOutButton);
  }
}
