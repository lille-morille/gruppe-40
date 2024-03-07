package no.ntnu.idi.stud;

import no.ntnu.idi.stud.models.Vector2D;
import no.ntnu.idi.stud.transformations.AffineTransform2D;

/**
 * The type Chaos canvas.
 */
public class ChaosCanvas {
  private final int[][] canvas;
  private final int width;
  private final int height;
  private final Vector2D minCoords;
  private final Vector2D maxCoords;
  private final AffineTransform2D transformCoordsToIndices;

  /**
   * Instantiates a new Chaos canvas.
   *
   * @param canvas                   the canvas
   * @param width                    the width
   * @param height                   the height
   * @param minCoords                the min coords
   * @param maxCoords                the max coords
   * @param transformCoordsToIndices the transform coords to indices
   */
  public ChaosCanvas(int[][] canvas, int width, int height, Vector2D minCoords, Vector2D maxCoords,
      AffineTransform2D transformCoordsToIndices) {
    this.canvas = canvas;
    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.transformCoordsToIndices = transformCoordsToIndices;
  }

  /**
   * Get pixel int.
   *
   * @param point the point
   * @return the int
   */
  public int getPixel (Vector2D point){
    Vector2D newVector = transformCoordsToIndices.transform(point);
    return canvas [(int) newVector.getX0()][(int) newVector.getX1()];
  }

  /**
   * Put pixel.
   *
   * @param point the point
   */
  public void putPixel (Vector2D point){
    Vector2D newVector = transformCoordsToIndices.transform(point);
    canvas [(int) newVector.getX0()][(int) newVector.getX1()] = 1;
  }

  /**
   * Get canvas array int [ ] [ ].
   *
   * @return the int [ ] [ ]
   */
  public int[][] getCanvasArray() {
    return canvas;
  }

  /**
   * Clear.
   */
  public void clear() {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        canvas[i][j] = 0;
      }
    }
  }
}
