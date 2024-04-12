package no.ntnu.idi.stud.dispatch;

import no.ntnu.idi.stud.model.ChaosGame;

/**
 * Observer for views and components that need to listen to changes in the chaos game.
 */
public interface ChaosGameObserver {
  /**
   * Called whenever the game has been updated.
   * @param game The new game to display.
   */
  void onNotified(ChaosGame game);
}
