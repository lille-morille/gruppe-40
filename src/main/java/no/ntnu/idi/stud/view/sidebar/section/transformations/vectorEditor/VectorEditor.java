package no.ntnu.idi.stud.view.sidebar.section.transformations.vectorEditor;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.dispatch.VectorHandler;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;

public class VectorEditor extends VBox implements Observer<Vector2D> {
  private TextField fieldx0;
  private TextField fieldx1;
  private ChangeListener<String> eventHandler;
  private VectorHandler handler;
  private Vector2D vector;

  public VectorEditor(VectorHandler handler, Vector2D vector) {
    super(5);
    this.handler = handler;
    this.vector = vector;
    initialize();
  }

  @Override
  public void onNotified(Vector2D resource) {
    if(resource.getX0() == Double.parseDouble(fieldx0.getText()) &&
        resource.getX1() == Double.parseDouble(fieldx1.getText())) {
      return;
    }

    // Temporarily remove listeners to avoid loop
    fieldx0.textProperty().removeListener(eventHandler);
    fieldx1.textProperty().removeListener(eventHandler);

    fieldx0.setText(String.valueOf(resource.getX0()));
    fieldx1.setText(String.valueOf(resource.getX1()));

    fieldx0.textProperty().addListener(eventHandler);
    fieldx1.textProperty().addListener(eventHandler);
  }

  private void initialize() {
    this.fieldx0 = new TextField();
    this.fieldx1 = new TextField();

    this.eventHandler = (observableValue, s, t1) -> {
      double x0;
      double x1;
      try {
        x0 = Double.parseDouble(fieldx0.getText());
        x1 = Double.parseDouble(fieldx1.getText());
      } catch (NumberFormatException e) {
        // Ignore error so the user can input a valid number
        return;
      }

      if(!Double.toString(x0).equals(fieldx0.getText()) ||
          !Double.toString(x1).equals(fieldx1.getText())) {
        return;
      }

      handler.handleSetVector(new Vector2D(x0, x1));
    };

    fieldx0.setPromptText("a00");
    fieldx0.setMaxWidth(50);
    fieldx0.setText(String.valueOf(vector.getX0()));

    fieldx1.setPromptText("a00");
    fieldx1.setMaxWidth(50);
    fieldx1.setText(String.valueOf(vector.getX1()));

    fieldx0.textProperty().addListener(eventHandler);
    fieldx1.textProperty().addListener(eventHandler);

    VBox box = new VBox();
    box.getChildren().addAll(fieldx0, fieldx1);

    var label = new Label("Vector");
    getChildren().addAll(label, box);
  }
}
