package no.ntnu.idi.stud.view.button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.StyledComponent;

/**
 * A button with an icon.
 *
 * <p>Is used as a secondary button in the application.
 */
public class IconButton extends HBox implements StyledComponent {
  /**
   * Constructs an IconButton with the given icon and click handler.
   *
   * @param icon    The icon to display
   * @param onClick The event handler to run when the button is clicked
   */
  public IconButton(String icon,
                    javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> onClick) {
    addStylesheet("icon-button");
    getStyleClass().add("icon-button");

    Icon iconView = new Icon(icon);
    iconView.fitWidthProperty().setValue(15);
    iconView.fitHeightProperty().setValue(15);

    getChildren().add(iconView);

    setOnMouseClicked(onClick);
  }
}
