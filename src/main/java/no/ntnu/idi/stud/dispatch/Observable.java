package no.ntnu.idi.stud.dispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic observable resource base class for the observer pattern.
 *
 * @param <T> The type of resource to be observed. Observers must implement the {@link Observer}
 *            interface of the same type.
 */
public abstract class Observable<T> {
  protected Observable() {
    this.observers = new ArrayList<>();
  }

  private final List<Observer<T>> observers;

  /**
   * Notify all observers that the resource has been updated.
   *
   * @param resource The updated resource.
   */
  protected void notifyObservers(T resource) {
    for (Observer<T> observer : observers) {
      observer.onNotified(resource);
    }
  }

  /**
   * Register a new observer to the list of observers. Will be notified of all updated.
   *
   * @param observer The observer to add.
   */
  public void addObserver(Observer<T> observer) {
    observers.add(observer);
  }
}
