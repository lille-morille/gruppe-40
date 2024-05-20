package no.ntnu.idi.stud.singleton;

import javafx.stage.Stage;

/**
 * Singleton class for managing the Stage of the application.
 *
 * <p>Is used by for example the Toast component to render on the stage
 */
public class StageSingleton {
  // Static variable reference of single_instance
  // of type Singleton
  private static StageSingleton single_instance = null;

  // Declaring a variable of type String
  public Stage stage;

  /**
   * Creates the singleton.
   */
  private StageSingleton(Stage stage) {
    this.stage = stage;
  }

  /**
   * Creates the singleton using a stage initial value.
   *
   * @param stage The initial stage value
   */
  public static void createWithStage(Stage stage) {
    if (single_instance == null) {
      single_instance = new StageSingleton(stage);
    }
  }

  /**
   * Creates an instance of the StageSingleton class or returns the
   * existing instance.
   */
  public static synchronized StageSingleton getInstance() {
    if (single_instance == null) {
      throw new RuntimeException("StageSingleton has not been initialized");
    }

    return single_instance;
  }
}
