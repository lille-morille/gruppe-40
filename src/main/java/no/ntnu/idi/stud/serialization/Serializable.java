package no.ntnu.idi.stud.serialization;

/**
 * Defines a serializable object that can be converted to a string for serialization.
 */
public interface Serializable {
  /**
   * Converts the object to a string that can be used for serialization.
   *
   * @return A serializable string
   */
  default String toSerializedString() {
    return getClass().getSimpleName() + "\n";
  }
}
