package no.ntnu.idi.stud.view.sidebar.section.transformations.matrixeditor;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.dispatch.MatrixHandler;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.view.StyledComponent;

/**
 * A matrix editor component for editing a single matrix.
 */
public class MatrixEditor extends VBox implements Observer<Matrix2x2>, StyledComponent {
  private TextField fielda00;
  private TextField fielda01;
  private TextField fielda10;
  private TextField fielda11;
  private ChangeListener<String> eventHandler;
  private final MatrixHandler handler;
  private final Matrix2x2 matrix;

  /**
   * Creates a new matrix editor using the given handler and matrix.
   *
   * @param handler The handler class that handles changes to the matrix
   * @param matrix  The matrix itself to display as an initial value before any observers run
   */
  public MatrixEditor(MatrixHandler handler, Matrix2x2 matrix) {
    super(5);
    this.handler = handler;
    this.matrix = matrix;
    initialize();
  }

  @Override
  public void onNotified(Matrix2x2 resource) {
    // Only update if the fields change
    if (Double.parseDouble(fielda00.getText()) == resource.getA00()
        && Double.parseDouble(fielda01.getText()) == resource.getA01()
        && Double.parseDouble(fielda10.getText()) == resource.getA10()
        && Double.parseDouble(fielda11.getText()) == resource.getA11()) {
      return;
    }

    // Temporarily remove listeners to avoid loop
    fielda00.textProperty().removeListener(eventHandler);
    fielda01.textProperty().removeListener(eventHandler);
    fielda10.textProperty().removeListener(eventHandler);
    fielda11.textProperty().removeListener(eventHandler);

    fielda00.setText(String.valueOf(resource.getA00()));
    fielda01.setText(String.valueOf(resource.getA01()));
    fielda10.setText(String.valueOf(resource.getA10()));
    fielda11.setText(String.valueOf(resource.getA11()));

    fielda00.textProperty().addListener(eventHandler);
    fielda01.textProperty().addListener(eventHandler);
    fielda10.textProperty().addListener(eventHandler);
    fielda11.textProperty().addListener(eventHandler);
  }

  private void initialize() {
    this.fielda00 = new TextField();
    this.fielda01 = new TextField();
    this.fielda10 = new TextField();
    this.fielda11 = new TextField();

    this.eventHandler = (observableValue, s, t1) -> {
      double a00 = 0;
      double a01 = 0;
      double a10 = 0;
      double a11 = 0;
      try {
        a00 = Double.parseDouble(fielda00.getText());
        a01 = Double.parseDouble(fielda01.getText());
        a10 = Double.parseDouble(fielda10.getText());
        a11 = Double.parseDouble(fielda11.getText());
      } catch (NumberFormatException e) {
        // If any is invalid, just do nothing so the user can input a correct value
        return;
      }

      if (!Double.toString(a00).equals(fielda00.getText())
          || !Double.toString(a01).equals(fielda01.getText())
          || !Double.toString(a10).equals(fielda10.getText())
          || !Double.toString(a11).equals(fielda11.getText())) {
        return;
      }

      handler.handleSetMatrix(new Matrix2x2(a00, a01, a10, a11));
    };

    fielda00.setPromptText("a00");
    fielda00.setMaxWidth(50);
    fielda00.setText(String.valueOf(matrix.getA00()));
    fielda00.textProperty().addListener(eventHandler);

    fielda01.setPromptText("a00");
    fielda01.setMaxWidth(50);
    fielda01.setText(String.valueOf(matrix.getA01()));
    fielda01.textProperty().addListener(eventHandler);

    fielda10.setPromptText("a00");
    fielda10.setMaxWidth(50);
    fielda10.setText(String.valueOf(matrix.getA10()));
    fielda10.textProperty().addListener(eventHandler);

    fielda11.setPromptText("a00");
    fielda11.setMaxWidth(50);
    fielda11.setText(String.valueOf(matrix.getA11()));
    fielda11.textProperty().addListener(eventHandler);

    GridPane grid = new GridPane();
    grid.add(fielda00, 0, 0);
    grid.add(fielda01, 1, 0);
    grid.add(fielda10, 0, 1);
    grid.add(fielda11, 1, 1);

    var label = new Label("Matrix");

    getChildren().addAll(label, grid);
  }
}
