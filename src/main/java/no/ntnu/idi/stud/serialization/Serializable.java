package no.ntnu.idi.stud.serialization;

public interface Serializable {
  /**
   * @return Converts the object to a string that can be used for serialization.
   */
  String toSerializedString();
}
