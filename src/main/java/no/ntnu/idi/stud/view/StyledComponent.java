package no.ntnu.idi.stud.view;

import java.util.Objects;
import javafx.collections.ObservableList;
import org.jetbrains.annotations.NotNull;

public interface StyledComponent {
  default void addStylesheet(@NotNull String path) {
    String url =
        (Objects.requireNonNull(getClass().getResource("/style/" + path + ".css"))).toExternalForm();
    getStylesheets().add(url);
  }

  ObservableList<String> getStylesheets();
}
