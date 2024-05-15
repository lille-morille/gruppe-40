package no.ntnu.idi.stud.view.button;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import no.ntnu.idi.stud.view.Icon;
import no.ntnu.idi.stud.view.StyledComponent;

/**
 * A button with both text and an icon.
 * <p>
 * Is used as a primary button in the application.
 */
public class IconTextButton extends HBox implements StyledComponent {
  /**
   * Constructs an IconTextButton with the given text and icon.
   * @param text The text to display
   * @param icon The icon to display
   * @param onClick The event handler to run when the button is clicked
   */
  public IconTextButton(String text, String icon,
                    javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> onClick) {
    addStylesheet("icon-text-button");
    getStyleClass().add("icon-text-button");

    Label label = new Label(text);
    label.getStyleClass().add("label");
    Icon iconView = new Icon(icon);
    iconView.fitWidthProperty().setValue(10);
    iconView.fitHeightProperty().setValue(10);

    getChildren().addAll(iconView, label);

    setOnMouseClicked(onClick);
  }
}
