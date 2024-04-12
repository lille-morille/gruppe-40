package no.ntnu.idi.stud.view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.ntnu.idi.stud.controller.ChaosGameController;

public class ChaosGameView extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    ChaosGameController controller = new ChaosGameController();
    var root = new BorderPane();

    var canvas = new ChaosGameCanvas(600, 800);
    controller.addObserver(canvas);
    root.setCenter(canvas);

    var sidebar = new ChaosGameSidebar(controller);
    controller.addObserver(sidebar);
    root.setLeft(sidebar);

    var scene = new javafx.scene.Scene(root);
    stage.setScene(scene);

    stage.show();
  }
}
