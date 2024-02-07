package no.ntnu.idi.stud.transformations;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idi.stud.models.Matrix2x2;
import no.ntnu.idi.stud.models.Vector2D;
import org.junit.jupiter.api.Test;

class AffineTransform2DTest {

  @Test
  void transform() {
    Matrix2x2 A = new Matrix2x2(1, 2, 3, 4);
    Vector2D b = new Vector2D(2, 1);
    Vector2D x = new Vector2D(2,1);
    AffineTransform2D affineTransform = new AffineTransform2D(A, b);
    Vector2D affineTransformResult = affineTransform.transform(x);
    Vector2D result = new Vector2D(6, 11);

    assertEquals(affineTransformResult, result);
    }

  @Test
  void tranform1() {
    Matrix2x2 A = new Matrix2x2(12, 98, 71, 3);
    Vector2D b = new Vector2D(23, 44);
    Vector2D x = new Vector2D(7,9);
    AffineTransform2D affineTransform = new AffineTransform2D(A, b);
    Vector2D affineTransformResult = affineTransform.transform(x);
    Vector2D result = new Vector2D(989, 568);

    assertEquals(affineTransformResult, result);
  }

  @Test
  void transform2() {
    Matrix2x2 A = new Matrix2x2(13, 17, 3, 8);
    Vector2D b = new Vector2D(5, 6);
    Vector2D x = new Vector2D(2,11);
    AffineTransform2D affineTransform = new AffineTransform2D(A, b);
    Vector2D affineTransformResult = affineTransform.transform(x);
    Vector2D result = new Vector2D(218, 100);

    assertEquals(affineTransformResult, result);
  }
}

