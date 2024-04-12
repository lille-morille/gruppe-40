package no.ntnu.idi.stud.controller;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idi.stud.ChaosGame;
import no.ntnu.idi.stud.ChaosGameDescription;
import no.ntnu.idi.stud.observer.ChaosGameListener;
import no.ntnu.idi.stud.observer.ChaosGameObserver;

public class ChaosGameController implements ChaosGameListener {
  private ChaosGame game;
  private final List<ChaosGameObserver> observers;

  public ChaosGameController() {
    this.observers = new ArrayList<>();
    var description = ChaosGameDescription.empty();
    this.game = new ChaosGame(description, 0, 0);
    notifyObservers();
  }

  public void addObserver(ChaosGameObserver observer) {
    observers.add(observer);
  }

  public void runSteps(int steps) {
    game.runSteps(steps);
    notifyObservers();
  }

  public void setDescription(ChaosGameDescription description) {
    game = new ChaosGame(description, 0, 0);
    notifyObservers();
  }

  public void notifyObservers() {
    for (ChaosGameObserver observer : observers) {
      observer.updateCanvas(this.game.getCanvas());
    }
  }

  @Override
  public void onCreateGameClicked() {
    var description = ChaosGameDescription.empty();
    game = new ChaosGame(description, 0, 0);
    notifyObservers();
  }
}
