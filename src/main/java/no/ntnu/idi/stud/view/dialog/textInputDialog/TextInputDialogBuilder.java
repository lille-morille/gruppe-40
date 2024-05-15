package no.ntnu.idi.stud.view.dialog.textInputDialog;

import java.util.function.Consumer;

public class TextInputDialogBuilder {
  private String prompt;
  private String confirmButtonText;
  private String cancelButtonText;
  private Consumer<String> onSubmit;

  public TextInputDialogBuilder setPrompt(String prompt) {
    this.prompt = prompt;
    return this;
  }

  public TextInputDialogBuilder setConfirmButtonText(String confirmButtonText) {
    this.confirmButtonText = confirmButtonText;
    return this;
  }

  public TextInputDialogBuilder setCancelButtonText(String cancelButtonText) {
    this.cancelButtonText = cancelButtonText;
    return this;
  }

  public TextInputDialogBuilder setOnSubmit(Consumer<String> onSubmit) {
    this.onSubmit = onSubmit;
    return this;
  }

  public TextInputDialog createTextInputDialog() {
    return new TextInputDialog(prompt, confirmButtonText, cancelButtonText, onSubmit);
  }
}
