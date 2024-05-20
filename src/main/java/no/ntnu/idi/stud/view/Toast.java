package no.ntnu.idi.stud.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import no.ntnu.idi.stud.singleton.StageSingleton;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

/**
 * A class for creating toast messages.
 */
public class Toast extends StackPane implements StyledComponent {
  /**
   * Creates a toast.
   *
   * @param message The message to show
   * @param variant The toast variant to use (success, error, info)
   */
  public Toast(String message, Variant variant) {
    addStylesheet("toast");
    this.message = message;
    this.variant = variant;
  }

  /**
   * A toast variant. Affects the styling of the toast.
   */
  public enum Variant {
    SUCCESS, ERROR, INFO
  }

  final String message;
  final Variant variant;

  /**
   * Shows the toast to the user.
   */
  public void show() {
    Stage toastStage = new Stage();
    toastStage.initOwner(StageSingleton.getInstance().stage);
    toastStage.setResizable(false);
    toastStage.initStyle(StageStyle.TRANSPARENT);
    toastStage.setAlwaysOnTop(true);

    Text text = new Text(message);

    getStyleClass().add("toast");
    getChildren().add(text);
    setOpacity(0);
    setAlignment(Pos.BOTTOM_RIGHT);

    switch (variant) {
      case SUCCESS:
        getStyleClass().add("success");
        break;
      case ERROR:
        getStyleClass().add("error");
        break;
      case INFO:
        getStyleClass().add("info");
        break;
      default:
        throw new IllegalArgumentException("Invalid variant: " + variant);
    }


    Scene scene = new Scene(this);
    scene.setFill(Color.TRANSPARENT);
    toastStage.setScene(scene);

    // Position the toast in the bottom right corner of the parent window
    Stage ownerStage = StageSingleton.getInstance().stage;
    double dxOffset = ownerStage.getX() + ownerStage.getWidth() - 150; // Adjust width if needed
    double dyOffset = ownerStage.getY() + ownerStage.getHeight() - 80; // Adjust height if needed
    toastStage.setX(dxOffset);
    toastStage.setY(dyOffset);
    toastStage.show();

    Timeline fadeInTimeline = new Timeline();
    KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(200),
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
        KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(500),
            new KeyValue(toastStage.getScene().getRoot().opacityProperty(), 0));
        fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
        fadeOutTimeline.setOnFinished((aeb) -> toastStage.close());
        fadeOutTimeline.play();
      }).start();
    });
    fadeInTimeline.play();
  }
}
