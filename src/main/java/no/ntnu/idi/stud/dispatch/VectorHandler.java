package no.ntnu.idi.stud.dispatch;

import no.ntnu.idi.stud.model.Vector2D;

/**
 * Describes a handler for managing changes to a vector in a vector editor.
 */
public interface VectorHandler {
  /**
   * Handle the vector change.
   *
   * @param vector The new vector emitted by the editor
   */
  void handleSetVector(Vector2D vector);
}
