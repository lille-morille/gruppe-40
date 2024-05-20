package no.ntnu.idi.stud.view.sidebar.section.transformations;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.ChaosGameEventHandler;
import no.ntnu.idi.stud.dispatch.MatrixHandler;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.dispatch.VectorHandler;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.view.sidebar.section.transformations.matrixeditor.MatrixEditor;
import no.ntnu.idi.stud.view.sidebar.section.transformations.vectoreditor.VectorEditor;
import org.jetbrains.annotations.NotNull;

/**
 * Editor for transformations.
 */
public class TransformationsEditor extends VBox implements Observer<ChaosGame> {
  private final ChaosGameController controller;
  private int transformationCount;

  /**
   * Creates a new editor using the given controller.
   *
   * @param controller The controller to handle changes to the transformations.
   */
  public TransformationsEditor(ChaosGameController controller) {
    this.controller = controller;
  }

  @Override
  public void onNotified(ChaosGame game) {

    if (game == null) {
      return;
    }

    var description = game.getDescription();

    // only update if the count of transformations change, otherwise, we update for nothing,
    // we can defer updating to lower components that listen to matrices or vectors
    if (description.getTransforms().size() == transformationCount) {
      return;
    }

    getChildren().clear();
    transformationCount = description.getTransforms().size();

    for (int i = 0; i < description.getTransforms().size(); i++) {
      var transformation = description.getTransforms().get(i);
      var box = new VBox();
      box.setSpacing(5);
      var label = new Label(transformation.getClass().getSimpleName());
      box.getChildren().add(label);

      if (transformation.getClass() == AffineTransform2D.class) {
        var matrix = ((AffineTransform2D) transformation).getMatrix();
        var vector = ((AffineTransform2D) transformation).getVector();

        int finalI = i;
        var matrixAdaptor = new MatrixHandler() {
          final ChaosGameEventHandler handler = controller;
          final int transformationIndex = finalI;

          @Override
          public void handleSetMatrix(Matrix2x2 matrix) {
            handler.handleSetMatrix(transformationIndex, matrix);
          }
        };
        var matrixEditor = new MatrixEditor(matrixAdaptor, matrix);
        matrix.addObserver(matrixEditor);

        var vectorAdaptor = new VectorHandler() {
          final ChaosGameEventHandler handler = controller;
          final int transformationIndex = finalI;

          @Override
          public void handleSetVector(Vector2D vector) {
            handler.handleSetVector(transformationIndex, vector);
          }
        };
        var vectorEditor = new VectorEditor(vectorAdaptor, vector);
        vector.addObserver(vectorEditor);

        var expanded = new HBox();
        HBox.setHgrow(expanded, javafx.scene.layout.Priority.ALWAYS);

        var parent = new HBox();

        parent.getChildren().addAll(matrixEditor, expanded, vectorEditor);

        box.getChildren().add(parent);
      } else if (transformation.getClass() == JuliaTransform.class) {
        var complexEditor = getComplexEditor((JuliaTransform) transformation, i);

        box.getChildren().add(complexEditor);
      }

      getChildren().add(box);
    }
  }

  private @NotNull VectorEditor getComplexEditor(JuliaTransform transformation, int i) {
    var complex = transformation.getComplex();
    var complexAdaptor = new VectorHandler() {
      final ChaosGameEventHandler handler = controller;
      final int transformationIndex = i;

      @Override
      public void handleSetVector(Vector2D vector) {
        handler.handleSetVector(transformationIndex, vector);
      }
    };
    var complexEditor = new VectorEditor(complexAdaptor, complex);
    complex.addObserver(complexEditor);
    return complexEditor;
  }
}
