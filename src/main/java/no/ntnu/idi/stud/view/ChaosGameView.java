package no.ntnu.idi.stud.view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.singleton.StageSingleton;
import no.ntnu.idi.stud.view.sidebar.ChaosGameSidebar;

public class ChaosGameView extends Application {

  @Override
  public void start(Stage stage) {
    var canvasWidth = 500;
    var canvasHeight = 500;

    StageSingleton.createWithStage(stage);
    ChaosGameController controller = new ChaosGameController();
    ChaosGameControllerSingleton.createWithController(controller);

    var root = new BorderPane();

    var canvas = new ChaosGameCanvas(canvasWidth, canvasHeight);
    controller.getGame().addObserver(canvas);
    root.setCenter(canvas);

    var sidebar = new ChaosGameSidebar();
    root.setLeft(sidebar);

    var scene = new javafx.scene.Scene(root);
    stage.setScene(scene);

    controller.initialize();
    stage.show();
  }
}
