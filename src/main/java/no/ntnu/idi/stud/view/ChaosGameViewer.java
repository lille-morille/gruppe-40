package no.ntnu.idi.stud.view;

import javafx.scene.layout.StackPane;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;

/**
 * A GUI view for the chaos game application.
 */
public class ChaosGameViewer extends StackPane implements Observer<ChaosGameController> {
  static int canvasWidth = 500;
  static int canvasHeight = 500;
  ChaosGameCanvas canvas;

  /**
   * Creates the main view for the application.
   */
  public ChaosGameViewer() {
    var controller = ChaosGameControllerSingleton.getInstance().controller;
    canvas = new ChaosGameCanvas(canvasWidth, canvasHeight);
    controller.getGame().addObserver(canvas);

    // Add listeners to the parent container's size to update the Canvas size
    this.widthProperty().addListener((observable, oldValue, newValue) -> {
      canvas.setWidth((double) newValue);
      canvas.drawPixels(controller.getGame().getCanvas());
    });

    this.heightProperty().addListener((observable, oldValue, newValue) -> {
      canvas.setHeight((double) newValue);
      canvas.drawPixels(controller.getGame().getCanvas());
    });

    var zoomControls = new ChaosGameViewerZoomControls();
    StackPane.setAlignment(zoomControls, javafx.geometry.Pos.BOTTOM_RIGHT);

    getChildren().addAll(canvas, zoomControls);
  }

  @Override
  public void onNotified(ChaosGameController resource) {
    resource.getGame().addObserver(canvas);
  }
}
