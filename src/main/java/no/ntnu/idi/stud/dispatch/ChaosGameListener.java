package no.ntnu.idi.stud.dispatch;

import java.util.List;
import no.ntnu.idi.stud.model.ChaosCanvas;

/**
 * Describes all event listeners that need to be dispatched from the view to the controller.
 */
public interface ChaosGameListener {
  /**
   * Called when the user clicks the "Create Game" button.
   */
  abstract void onCreateGameClicked();

  /**
   * Called when the user clicks the "Load Game" button.
   */
  abstract void onLoadGameFromFileClicked();
}
