package no.ntnu.idi.stud.view.dialog.textinputdialog;

import java.util.function.Consumer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * An input dialog for inputting a single text string.
 */
public class TextInputDialog {
  final String prompt;
  final String confirmButtonText;
  final String cancelButtonText;
  final Consumer<String> onSubmit;

  /**
   * Create a new text input dialog.
   *
   * @param prompt The prompt to show to the user
   * @param confirmButtonText The text to show on the confirm action button
   * @param cancelButtonText The text to show on the cancel action button
   * @param onSubmit The function to trigger on submitting the dialog
   */
  public TextInputDialog(String prompt, String confirmButtonText, String cancelButtonText,
                         Consumer<String> onSubmit) {
    this.prompt = prompt;
    this.confirmButtonText = confirmButtonText;
    this.cancelButtonText = cancelButtonText;
    this.onSubmit = onSubmit;
  }

  /**
   * Shows the dialog to the user.
   */
  public void show() {
    Stage popUp = new Stage();
    popUp.initModality(Modality.APPLICATION_MODAL);


    Button btnDelete = new Button(confirmButtonText);
    btnDelete.setBackground(Background.fill(Color.GREEN));
    btnDelete.setTextFill(Color.WHITE);
    Button btnCancel = new Button(cancelButtonText);

    HBox containerBtn = new HBox(btnDelete, btnCancel);
    containerBtn.setAlignment(Pos.CENTER);
    containerBtn.setSpacing(10);

    TextField inputField = new TextField();

    btnDelete.setOnAction(actionEvent -> {
      onSubmit.accept(inputField.getText());
      popUp.close();
    });

    btnCancel.setOnAction(actionEvent -> popUp.close());

    Text requestMessage = new Text(prompt);
    VBox showBox = new VBox(10);
    showBox.getChildren().addAll(requestMessage, inputField, containerBtn);
    showBox.setAlignment(Pos.CENTER);

    Scene popupScene = new Scene(showBox, 350, 150);

    popUp.setScene(popupScene);
    popUp.showAndWait();
  }
}
