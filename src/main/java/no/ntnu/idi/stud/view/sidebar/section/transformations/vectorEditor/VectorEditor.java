package no.ntnu.idi.stud.view.sidebar.section.transformations.vectorEditor;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;

public class VectorEditor extends HBox implements Observer<Vector2D> {
  private final ChaosGameController controller;
  private final int transformationIndex;
  TextField fieldx0;
  TextField fieldx1;

  public VectorEditor(ChaosGameController controller, int transformationIndex) {
    this.controller = controller;
    this.transformationIndex = transformationIndex;
    initialize();
  }

  @Override
  public void onNotified(Vector2D resource) {
    fieldx0.setText(String.valueOf(resource.getX0()));
    fieldx1.setText(String.valueOf(resource.getX1()));
  }

  private void initialize() {
    var transformation = controller.getGame().getDescription().getTransforms().get(transformationIndex);
    Vector2D vector;
    if(transformation instanceof AffineTransform2D) {
      vector = ((AffineTransform2D) transformation).getVector();
    } else {
      vector = ((JuliaTransform) transformation).getComplex();
    }

    this.fieldx0 = new TextField();
    fieldx0.setPromptText("a00");
    fieldx0.setText(String.valueOf(vector.getX0()));

    this.fieldx1 = new TextField();
    fieldx1.setPromptText("a00");
    fieldx1.setText(String.valueOf(vector.getX1()));

    VBox box = new VBox();
    box.getChildren().addAll(fieldx0, fieldx1);

    var submitBtn = new Button("Submit");
    submitBtn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
      var x0 = Double.parseDouble(fieldx0.getText());
      var x1 = Double.parseDouble(fieldx1.getText());

      controller.handleSetVector(transformationIndex, new Vector2D(x0, x1));
    });

    getChildren().addAll(box, submitBtn);
  }
}
