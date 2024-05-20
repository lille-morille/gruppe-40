package no.ntnu.idi.stud.singleton;

import no.ntnu.idi.stud.controller.ChaosGameController;

/**
 * Singleton class for managing the Stage of the application.
 *
 * <p>Is used by for example the Toast component to render on the stage
 */
public class ChaosGameControllerSingleton {
  // Static variable reference of single_instance
  // of type Singleton
  private static ChaosGameControllerSingleton single_instance = null;

  // Declaring a variable of type String
  public ChaosGameController controller;

  /**
   * Creates the singleton.
   */
  private ChaosGameControllerSingleton(ChaosGameController controller) {
    this.controller = controller;
  }

  /**
   * Instantiates the singleton with a controller.
   *
   * @param controller The controller to use.
   */
  public static void createWithController(ChaosGameController controller) {
    if (single_instance == null) {
      single_instance = new ChaosGameControllerSingleton(controller);
    }
  }

  /**
   * Creates an instance of the ChaosGameSingleton class or returns the
   * existing instance.
   */
  public static synchronized ChaosGameControllerSingleton getInstance() {
    if (single_instance == null) {
      throw new RuntimeException("ChaosGameSingleton has not been initialized");
    }

    return single_instance;
  }
}
