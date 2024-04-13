package no.ntnu.idi.stud.model;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idi.stud.dispatch.Observable;

public class SavedGames extends Observable<List<String>> {
  private List<String> savedGames;

  public SavedGames() {
    this.savedGames = new ArrayList<>();
  }

  public void addSavedGame(String game) {
    if (!savedGames.contains(game)) {
      savedGames.add(game);
      notifyObservers(savedGames);
    }
  }

  public void removeSavedGame(String game) {
    savedGames.remove(game);
    notifyObservers(savedGames);
  }

  public List<String> getSavedGames() {
    return savedGames;
  }

  public void setSavedGames(List<String> savedGames) {
    this.savedGames = savedGames;
    notifyObservers(savedGames);
  }
}
