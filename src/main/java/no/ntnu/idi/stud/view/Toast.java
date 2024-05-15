package no.ntnu.idi.stud.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import no.ntnu.idi.stud.singleton.StageSingleton;

/**
 * A class for creating toast messages.
 */
public class Toast extends VBox implements StyledComponent {
  public Toast(String message, Variant variant) {
    addStylesheet("toast");
    this.message = message;
  }

  public enum Variant {
    SUCCESS,
    ERROR,
    INFO
  }

  final String message;

  public void show() {
    Stage toastStage = new Stage();
    toastStage.initOwner(StageSingleton.getInstance().stage);
    toastStage.setResizable(false);
    toastStage.initStyle(StageStyle.TRANSPARENT);

    Text text = new Text(message);
    text.setFont(Font.font("Verdana", 40));
    text.setFill(Color.RED);

    StackPane root = new StackPane(text);
    root.getStyleClass().add("toast");
    root.setOpacity(0);

    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    toastStage.setScene(scene);
    toastStage.show();

    Timeline fadeInTimeline = new Timeline();
    KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(500),
        new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 1));
    fadeInTimeline.getKeyFrames().add(fadeInKey1);
    fadeInTimeline.setOnFinished((ae) -> {
      new Thread(() -> {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        Timeline fadeOutTimeline = new Timeline();
        KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(1500),
            new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 0));
        fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
        fadeOutTimeline.setOnFinished((aeb) -> toastStage.close());
        fadeOutTimeline.play();
      }).start();
    });
    fadeInTimeline.play();
  }
}
