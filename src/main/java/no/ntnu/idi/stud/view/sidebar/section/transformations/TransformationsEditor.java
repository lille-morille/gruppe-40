package no.ntnu.idi.stud.view.sidebar.section.transformations;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.controller.ChaosGameController;
import no.ntnu.idi.stud.dispatch.Observer;
import no.ntnu.idi.stud.model.ChaosGame;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.view.sidebar.section.transformations.matrixEditor.MatrixEditor;
import no.ntnu.idi.stud.view.sidebar.section.transformations.vectorEditor.VectorEditor;

public class TransformationsEditor extends VBox implements Observer<ChaosGame> {
  private final ChaosGameController controller;

  public TransformationsEditor(ChaosGameController controller) {
    this.controller = controller;
  }

  @Override
  public void onNotified(ChaosGame game) {
    getChildren().clear();

    var description = game.getDescription();

    for (int i = 0; i < description.getTransforms().size(); i++) {
      var transformation = description.getTransforms().get(i);

      var box = new VBox();
      box.setSpacing(5);
      var label = new Label(transformation.getClass().getSimpleName());
      box.getChildren().add(label);

      if (transformation.getClass() == AffineTransform2D.class) {
        var matrix = ((AffineTransform2D) transformation).getMatrix();
        var vector = ((AffineTransform2D) transformation).getVector();

        var matrixEditor = new MatrixEditor(controller, i);
        matrix.addObserver(matrixEditor);

        var vectorEditor = new VectorEditor(controller, i);
        vector.addObserver(vectorEditor);

        box.getChildren().addAll(matrixEditor, vectorEditor);
      } else if (transformation.getClass() == JuliaTransform.class) {
        var complex = ((JuliaTransform) transformation).getComplex();
        var complexEditor = new VectorEditor(controller, i);
        complex.addObserver(complexEditor);

        box.getChildren().add(complexEditor);
      }

      getChildren().add(box);
    }
  }
}
