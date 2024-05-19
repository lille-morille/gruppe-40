package no.ntnu.idi.stud.view.dialog.confirmDialog;

/**
 * A builder-style constructor for the ConfirmDialog.
 */
public class ConfirmDialogBuilder {
  private Runnable onConfirm;
  private String prompt;
  private String confirmButtonText;
  private String cancelButtonText;


  /**
   * Sets the callback to run when the user confirms.
   *
   * @param onConfirm The callback
   * @return The builder
   */
  public ConfirmDialogBuilder setOnConfirm(Runnable onConfirm) {
    this.onConfirm = onConfirm;
    return this;
  }


  /**
   * Sets the prompt to display to the user.
   *
   * @param prompt The prompt
   * @return The builder
   */
  public ConfirmDialogBuilder setPrompt(String prompt) {
    this.prompt = prompt;
    return this;
  }

  /**
   * Sets the text on the confirm button.
   *
   * @param confirmButtonText The text to display on the confirm button.
   * @return The builder
   */
  public ConfirmDialogBuilder setConfirmButtonText(String confirmButtonText) {
    this.confirmButtonText = confirmButtonText;
    return this;
  }

  /**
   * Sets the text on the cancel button.
   *
   * @param cancelButtonText The text to display on the cancel button.
   * @return The builder
   */
  public ConfirmDialogBuilder setCancelButtonText(String cancelButtonText) {
    this.cancelButtonText = cancelButtonText;
    return this;
  }

  /**
   * Build the ConfirmDialog.
   *
   * @return The finished confirmation dialog
   */
  public ConfirmDialog createConfirmDialog() {
    return new ConfirmDialog(onConfirm, prompt, confirmButtonText, cancelButtonText);
  }
}
