package no.ntnu.idi.stud.dispatch;

import no.ntnu.idi.stud.model.ChaosGame;

/**
 * Observer for views and components that need to listen to changes in the chaos game.
 */
public interface Observer<T> {
  /**
   * Called whenever the resource (that is listened to) has been updated.
   *
   * @param resource The resource that has been updated
   */
  void onNotified(T resource);
}
