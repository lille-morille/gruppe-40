package no.ntnu.idi.stud.view.iconButton;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import no.ntnu.idi.stud.view.StyledComponent;
import no.ntnu.idi.stud.view.icon.Icon;

/**
 * A button with both text and an icon.
 * <p>
 * Is used as a primary button in the application.
 */
public class IconButton extends HBox implements StyledComponent {
  /**
   * Constructs an IconButton with the given text and icon.
   * @param text The text to display
   * @param icon The icon to display
   * @param onClick The event handler to run when the button is clicked
   */
  public IconButton(String text, String icon,
                    javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> onClick) {
    addStylesheet("icon-button.css");
    getStyleClass().add("icon-button");

    Label label = new Label(text);
    label.getStyleClass().add("label");
    Icon iconView = new Icon(icon);
    iconView.fitWidthProperty().setValue(10);
    iconView.fitHeightProperty().setValue(10);

    getChildren().addAll(iconView, label);

    setOnMouseClicked(onClick);
  }
}
