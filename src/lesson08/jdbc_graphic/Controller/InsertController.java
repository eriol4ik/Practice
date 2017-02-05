package lesson08.jdbc_graphic.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lesson08.jdbc_graphic.Domain.Contact;

import java.io.IOException;

/**
 * Created by eriol4ik on 22/01/2017.
 */
public class InsertController {
    @FXML private TextField rowId;
    @FXML private TextField rowName;
    @FXML private TextField rowSurname;
    @FXML private TextField rowAge;
    @FXML private TextField rowEmail;
    @FXML private TextField rowMobile;

    @FXML private Button cancelButton;
    private Contact contact;

    public void initialize() {
    }

    @FXML
    public void onActionCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onActionInsertButton() throws IOException {
        if (checkInput(rowId) & checkInput(rowName) & checkInput(rowSurname) &
                checkInput(rowAge) & checkInput(rowEmail) & checkInput(rowMobile)) {
            contact = new Contact(Integer.parseInt(rowId.getText()), rowName.getText(), rowSurname.getText(), Integer.parseInt(rowAge.getText()), rowEmail.getText(), Integer.parseInt(rowMobile.getText()));

            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }


    public boolean checkInput(TextField source) {
        if (source.getText().equals("")) {
            source.setStyle("-fx-border-color: red");
            return false;
        }

        if (source == rowId || source == rowAge || source == rowMobile) { // по-хорошему, создать метод source.isNumber()
            try {
                Integer.parseInt(source.getText());
                source.setStyle("-fx-border-color: inherit");
                return true;
            } catch (NumberFormatException nfe) {
                source.setStyle("-fx-border-color: red");
                return false;
            }
        }

        source.setStyle("-fx-border-color: inherit");
        return true;
    }

    public Contact getContact() {
        return contact;
    }
}
