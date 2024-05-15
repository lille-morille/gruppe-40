package no.ntnu.idi.stud.view.sidebar.filetree.custom;

import java.util.List;
import no.ntnu.idi.stud.dispatch.Observable;

public class CustomFileTreeModel extends Observable<CustomFileTreeModel> {
  public CustomFileTreeModel() {
  }

  private List<String> descriptions;

  public List<String> getDescriptions() {
    return descriptions;
  }

  void loadDescriptions(List<String> descriptions) {
    this.descriptions = descriptions;
    notifyObservers(this);
  }

  void deleteDescription(String name) {
    descriptions.stream().filter(d -> d.equals(name)).findFirst().ifPresent(d -> {
      descriptions.remove(d);
      notifyObservers(this);
    });
  }

  void createDescription(String name) {
    descriptions.add(name);
    notifyObservers(this);
  }
}
