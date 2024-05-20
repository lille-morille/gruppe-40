package no.ntnu.idi.stud.view;

import java.util.Objects;
import javafx.collections.ObservableList;
import org.jetbrains.annotations.NotNull;

/**
 * A component that can be styled with CSS.
 */
public interface StyledComponent {
  /**
   * Add a stylesheet to this component.
   *
   * @param name The name of the stylesheet, relative to the style folder in the resources.
   *             The name should not include the file extension.
   */
  default void addStylesheet(@NotNull String name) {
    String url = (Objects.requireNonNull(
        getClass().getResource("/style/" + name + ".css"))).toExternalForm();
    getStylesheets().add(url);
  }

  ObservableList<String> getStylesheets();
}
