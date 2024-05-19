package no.ntnu.idi.stud.view.sidebar.section.transformations.matrixEditor;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.view.StyledComponent;

public class MatrixEditor extends VBox implements Observer<Matrix2x2>, StyledComponent {
  private final ChaosGameController controller;
  private final int transformationIndex;
  TextField fielda00;
  TextField fielda01;
  TextField fielda10;
  TextField fielda11;

  public MatrixEditor(ChaosGameController controller, int transformationIndex) {
    super(5);
    this.controller = controller;
    this.transformationIndex = transformationIndex;
    initialize();
  }

  @Override
  public void onNotified(Matrix2x2 resource) {
    fielda00.setText(String.valueOf(resource.getA00()));
    fielda01.setText(String.valueOf(resource.getA01()));
    fielda10.setText(String.valueOf(resource.getA10()));
    fielda11.setText(String.valueOf(resource.getA11()));
  }

  private void initialize() {
    var transformation =
        controller.getGame().getDescription().getTransforms().get(transformationIndex);
    var matrix = ((AffineTransform2D) transformation).getMatrix();

    this.fielda00 = new TextField();
    this.fielda01 = new TextField();
    this.fielda10 = new TextField();
    this.fielda11 = new TextField();

    var eventHandler = new EventHandler<InputMethodEvent>() {
      @Override
      public void handle(InputMethodEvent inputMethodEvent) {
        var a00 = Double.parseDouble(fielda00.getText());
        var a01 = Double.parseDouble(fielda01.getText());
        var a10 = Double.parseDouble(fielda10.getText());
        var a11 = Double.parseDouble(fielda11.getText());

        controller.handleSetMatrix(transformationIndex, new Matrix2x2(a00, a01, a10, a11));
      }
    };

    fielda00.setPromptText("a00");
    fielda00.setText(String.valueOf(matrix.getA00()));
    fielda00.setOnInputMethodTextChanged(eventHandler);

    fielda01.setPromptText("a00");
    fielda01.setText(String.valueOf(matrix.getA01()));
    fielda01.setOnInputMethodTextChanged(eventHandler);

    fielda10.setPromptText("a00");
    fielda10.setText(String.valueOf(matrix.getA10()));
    fielda10.setOnInputMethodTextChanged(eventHandler);

    fielda11.setPromptText("a00");
    fielda11.setText(String.valueOf(matrix.getA11()));
    fielda11.setOnInputMethodTextChanged(eventHandler);

    GridPane grid = new GridPane();
    grid.add(fielda00, 0, 0);
    grid.add(fielda01, 1, 0);
    grid.add(fielda10, 0, 1);
    grid.add(fielda11, 1, 1);

    var label = new Label("Matrix");

    getChildren().addAll(label, grid);
  }
}
