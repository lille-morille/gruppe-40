package no.ntnu.idi.stud.view.sidebar.section.files.filetree.custom;

import java.util.List;
import no.ntnu.idi.stud.dispatch.Observable;

public class CustomFileTreeModel extends Observable<CustomFileTreeModel> {
  public CustomFileTreeModel() {
  }

  private List<String> descriptions;

  private String selectedDescription;

  public List<String> getDescriptions() {
    return descriptions;
  }

  public void loadDescriptions(List<String> descriptions) {
    this.descriptions = descriptions;
    notifyObservers(this);
  }

  public void deleteDescription(String name) {
    descriptions.stream().filter(d -> d.equals(name)).findFirst().ifPresent(d -> {
      descriptions.remove(d);
      notifyObservers(this);
    });
  }

  public void createDescription(String name) {
    descriptions.add(name);
    selectedDescription = name;
    notifyObservers(this);
  }

  public String getSelectedDescription() {
    return selectedDescription;
  }

  public void setSelectedDescription(String selectedDescription) {
    this.selectedDescription = selectedDescription;
    notifyObservers(this);
  }
}
