package no.ntnu.idi.stud.model;

import no.ntnu.idi.stud.transformation.AffineTransform2D;

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
   * @param width                    the width
   * @param height                   the height
   * @param minCoords                the min coords
   * @param maxCoords                the max coords
   */
  public ChaosCanvas(int width, int height, Vector2D minCoords, Vector2D maxCoords) {
    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;

    this.canvas = new int[width][height];

    //The canvas is a 2D array of integers. Each element in the array represents a pixel in the
    double deltaXCoords = maxCoords.getX0() - minCoords.getX0();
    double deltaYCoords = maxCoords.getX1() - minCoords.getX1();
    double deltaXIndices = width - 1;
    double deltaYIndices = height - 1;


    //The transformation matrix that scales the coordinates to the indices of the canvas.
    Matrix2x2 scaleMatrix = new Matrix2x2(
        deltaXIndices / deltaXCoords,
        0,
        0,
        deltaYIndices / deltaYCoords);

    //The transformation vector that offsets the coordinates to the indices of the canvas.
    Vector2D offsetVector = new Vector2D(
        -minCoords.getX0() * deltaXIndices / deltaXCoords,
        -minCoords.getX1() * deltaYIndices / deltaYCoords);

    //The transformation that transforms coordinates to indices.
    this.transformCoordsToIndices = new AffineTransform2D(scaleMatrix, offsetVector);
  }

  /**
   * Gets width.
   * @return width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets height.
   * @return height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Get pixel int.
   *
   * @param point the point
   * @return the int
   */
  public int getPixel (Vector2D point){
    return canvas [(int) point.getX0()][(int) point.getX1()];
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
