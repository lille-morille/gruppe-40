package no.ntnu.idi.stud.view.dialog.confirmDialog;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A graphical confirmation dialog.
 */
public class ConfirmDialog {
  private final Runnable onConfirm;
  private final String prompt;
  private final String confirmButtonText;
  private final String cancelButtonText;


  /**
   * Construct a confirmation dialog from options.
   *
   * @param onConfirm The callback to run when the user clicks the confirm button
   * @param prompt The prompt to display when the dialog opens
   * @param confirmButtonText The text to display on the confirm button
   * @param cancelButtonText The text to display on the cancel button
   */
  public ConfirmDialog(Runnable onConfirm, String prompt, String confirmButtonText,
                       String cancelButtonText) {
    this.onConfirm = onConfirm;
    this.prompt = prompt;
    this.confirmButtonText = confirmButtonText;
    this.cancelButtonText = cancelButtonText;
  }

  /**
   * Show the dialog to the user.
   */
  public void show() {
    Stage popUp = new Stage();
    popUp.initModality(Modality.APPLICATION_MODAL);

    Text requestMessage =
        new Text(prompt);

    Button btnDelete = new Button(confirmButtonText);
    btnDelete.setBackground(Background.fill(Color.RED));
    btnDelete.setTextFill(Color.WHITE);
    Button btnCancel = new Button(cancelButtonText);

    HBox containerBtn = new HBox(btnDelete, btnCancel);
    containerBtn.setAlignment(Pos.CENTER);
    containerBtn.setSpacing(10);

    btnDelete.setOnAction(actionEvent -> {
      onConfirm.run();
      popUp.close();
    });

    btnCancel.setOnAction(actionEvent -> popUp.close());

    VBox showBox = new VBox(10);
    showBox.getChildren().addAll(requestMessage, containerBtn);
    showBox.setAlignment(Pos.CENTER);

    Scene popupScene = new Scene(showBox, 350, 150);

    popUp.setScene(popupScene);
    popUp.showAndWait();
  }
}
