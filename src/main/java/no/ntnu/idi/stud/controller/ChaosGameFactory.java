package no.ntnu.idi.stud.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.ntnu.idi.stud.model.ChaosGameDescription;
import no.ntnu.idi.stud.model.Complex;
import no.ntnu.idi.stud.model.Matrix2x2;
import no.ntnu.idi.stud.model.Vector2D;
import no.ntnu.idi.stud.transformation.AffineTransform2D;
import no.ntnu.idi.stud.transformation.JuliaTransform;
import no.ntnu.idi.stud.transformation.Transform2D;

public class ChaosGameFactory {
  public static ChaosGameDescription sierpinskiTransformation() {
    List<Transform2D> transformations = new ArrayList<>();
    transformations.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5),
        new Vector2D(0, 0)));
    transformations.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5),
    new Vector2D(0.25, 0.5)));
    transformations.add(new AffineTransform2D(new Matrix2x2(0.5, 0, 0, 0.5),
        new Vector2D(0.5, 0)));
    return new ChaosGameDescription(new Vector2D(0, 0), new Vector2D(1, 1), transformations);
  }
  public static ChaosGameDescription barnsleyFernTransformation() {
    List<Transform2D> transformations = new ArrayList<>();
    transformations.add(new AffineTransform2D(new Matrix2x2(0, 0, 0, 0.16),
        new Vector2D(0, 0)));
    transformations.add(new AffineTransform2D
        (new Matrix2x2(0.85, 0.04, -0.04, 0.85), new Vector2D(0, 0.16)));
    transformations.add(new AffineTransform2D
        (new Matrix2x2(0.2, -0.26, 0.23, 0.22), new Vector2D(0, 0.16)));
    transformations.add
        (new AffineTransform2D(new Matrix2x2(-0.15, 0.28, 0.26, 0.24),
            new Vector2D(0, 0.44)));
    return new ChaosGameDescription
        (new Vector2D(-2.64, 0), new Vector2D(2.64, 10), transformations);
  }

  public static ChaosGameDescription juliaTransformation() {
    List<Transform2D> transformation = new ArrayList<>();
    transformation.add(new JuliaTransform(new Complex(-.74543, .11301)));
    return new ChaosGameDescription(new Vector2D(-1.6, -1), new Vector2D(1.6, 1), transformation);
  }

  public static ChaosGameDescription mandelbrotTransformation() {
    // kanskje feil må endre senere
    List<Transform2D> transformations = Collections.emptyList();
    return new ChaosGameDescription(new Complex(-2, -1),
        new Complex(1, 1), transformations);
  }
  public static ChaosGameDescription kochSnowflake() {

    return null;
  }
}
