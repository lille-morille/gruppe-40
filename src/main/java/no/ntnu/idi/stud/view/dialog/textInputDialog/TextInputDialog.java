package no.ntnu.idi.stud.view.dialog.textInputDialog;

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

public class TextInputDialog {
  final String prompt;
  final String confirmButtonText;
  final String cancelButtonText;
  final Consumer<String> onSubmit;

  public TextInputDialog(String prompt, String confirmButtonText, String cancelButtonText,
                         Consumer<String> onSubmit) {
    this.prompt = prompt;
    this.confirmButtonText = confirmButtonText;
    this.cancelButtonText = cancelButtonText;
    this.onSubmit = onSubmit;
  }

  public void show() {
    Stage popUp = new Stage();
    popUp.initModality(Modality.APPLICATION_MODAL);

    Text requestMessage = new Text(prompt);

    Button btnDelete = new Button(confirmButtonText);
    btnDelete.setBackground(Background.fill(Color.RED));
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

    VBox showBox = new VBox(10);
    showBox.getChildren().addAll(requestMessage, inputField, containerBtn);
    showBox.setAlignment(Pos.CENTER);

    Scene popupScene = new Scene(showBox, 350, 150);

    popUp.setScene(popupScene);
    popUp.showAndWait();
  }
}
