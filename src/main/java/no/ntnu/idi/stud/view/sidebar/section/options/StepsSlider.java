package no.ntnu.idi.stud.view.sidebar.section.options;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import no.ntnu.idi.stud.singleton.ChaosGameControllerSingleton;

public class StepsSlider extends VBox {
  private final Timeline debounceTimer;
  private final Slider slider;

  public StepsSlider(boolean debounce) {
    var controller = ChaosGameControllerSingleton.getInstance().controller;
    var steps = controller.getStepCount();

    slider = new Slider();
    slider.setMin(1);
    slider.setMax(1000000);
    slider.setValue(steps);

    debounceTimer = new Timeline();
    debounceTimer.setDelay(Duration.millis(200));
    debounceTimer.setCycleCount(1);

    if (debounce) {
      slider.valueProperty().addListener((observable, oldValue, newValue) -> {
        updateLabel();
        // Restart the debounce timer whenever the slider value changes
        debounceTimer.stop();
        debounceTimer.getKeyFrames().setAll(new KeyFrame(Duration.millis(200), event -> {
          controller.handleStepCountChange((int) Math.round(newValue.doubleValue()));
        }));
        debounceTimer.playFromStart();
      });
    } else {
      slider.valueProperty().addListener((observable, oldValue, newValue) -> {
        updateLabel();
        controller.handleStepCountChange((int) Math.round(newValue.doubleValue()));
      });
    }

    getChildren().add(slider);
    updateLabel();
  }

  private void updateLabel() {
    // Remove previous if present
    if (getChildren().size() == 2) {
      getChildren().remove(1);
    }
    var label = new Label("Steps: " + (int) slider.getValue());
    getChildren().add(label);
  }
}
