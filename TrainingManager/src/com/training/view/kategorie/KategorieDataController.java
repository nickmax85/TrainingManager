package com.training.view.kategorie;

import java.util.ResourceBundle;

import com.training.model.Kategorie;
import com.training.view.alert.InputValidatorAlert;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KategorieDataController {

	@FXML
	private ResourceBundle resources;

	@FXML
	public TextField nameField;

	private Kategorie data;

	private Stage dialogStage;

	@FXML
	private void initialize() {
		clearFields();
	}

	public void setData(Kategorie data) {

		this.data = data;

		if (data != null) {
			nameField.setText(data.getName());

		} else {
			clearFields();

		}

	}

	private void clearFields() {

		nameField.setText("");

	}

	public void setEditable(boolean editable) {

		nameField.setDisable(!editable);

	}

	public boolean isInputValid() {

		String text = "";

		if (nameField.getText() == null || nameField.getText().length() == 0)
			text += "Kein g�ltiger Name!\n";

		if (text.length() == 0) {
			return true;

		} else {
			new InputValidatorAlert(dialogStage, text).showAndWait();
			return false;
		}

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
