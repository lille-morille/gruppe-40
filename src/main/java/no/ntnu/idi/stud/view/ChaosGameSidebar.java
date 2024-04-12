package no.ntnu.idi.stud.view;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import no.ntnu.idi.stud.ChaosCanvas;
import no.ntnu.idi.stud.observer.ChaosGameListener;
import no.ntnu.idi.stud.observer.ChaosGameObserver;

public class ChaosGameSidebar extends VBox implements ChaosGameObserver {
  public ChaosGameSidebar(ChaosGameListener listener) {
    this.setPrefWidth(200);    // Set the width of the this

    Button btn1 = new Button("Create new game");
    btn1.addEventHandler(javafx.event.ActionEvent.ACTION, e -> listener.onCreateGameClicked());

    this.getChildren().addAll(btn1);
  }

  @Override
  public void updateCanvas(ChaosCanvas canvas) {

  }
}
