package no.ntnu.idi.stud.view.sidebar.section.options;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.dispatch.VectorHandler;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.sidebar.section.transformations.vectorEditor.VectorEditor;

public class MinMaxCoordsEditor extends VBox implements StyledComponent, Observer<ChaosGame> {
  final VectorEditor minCoordsField;
  final VectorEditor maxCoordsField;

  public MinMaxCoordsEditor() {
    super(5);
    var controller = ChaosGameControllerSingleton.getInstance().controller;

    var minCoords = controller.getGame().getDescription().getMinCoords();
    var maxCoords = controller.getGame().getDescription().getMaxCoords();

    var minCoordsHandler = new VectorHandler() {
      @Override
      public void handleSetVector(Vector2D vector) {
        controller.handleSetMinCoords(vector);
      }
    };

    this.minCoordsField = new VectorEditor(minCoordsHandler, minCoords);


    var maxCoordsHandler = new VectorHandler() {
      @Override
      public void handleSetVector(Vector2D vector) {
        controller.handleSetMaxCoords(vector);
      }
    };

    this.maxCoordsField = new VectorEditor(maxCoordsHandler, maxCoords);

    var label = new Label("Min/Max Coords");

    var hbox = new HBox(5);
    hbox.getChildren().addAll(minCoordsField, maxCoordsField);

    getChildren().addAll(label, hbox);
  }

  @Override
  public void onNotified(ChaosGame resource) {

  }
}
