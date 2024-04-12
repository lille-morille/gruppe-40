package no.ntnu.idi.stud.dispatch;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idi.stud.model.ChaosGame;

public class ChaosGameObservable {
  protected ChaosGameObservable() {
    this.observers = new ArrayList<>();
  }

  private final List<ChaosGameObserver> observers;

  protected void notifyObservers(ChaosGame game) {
    for (ChaosGameObserver observer : observers) {
      observer.onNotified(game);
    }
  }

  public void addObserver(ChaosGameObserver observer) {
    observers.add(observer);
  }
}
