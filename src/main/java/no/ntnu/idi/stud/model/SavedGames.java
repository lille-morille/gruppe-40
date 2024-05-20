package no.ntnu.idi.stud.model;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idi.stud.dispatch.Observable;

/**
 * A class representing a list of saved games.
 */
public class SavedGames extends Observable<List<String>> {
  private List<String> savedGames;

  /**
   * Initializes a new saved games instance using an empty list.
   */
  public SavedGames() {
    this.savedGames = new ArrayList<>();
  }

  /**
   * Adds a new saved game to the list of saved games.
   *
   * @param game The name of the saved game to add.
   */
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
