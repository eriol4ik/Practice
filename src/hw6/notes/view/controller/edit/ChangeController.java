package hw6.notes.view.controller.edit;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.util.InputDataChecker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by eriol4ik on 05/02/2017.
 */
public class ChangeController implements EditController {
    private NotebookService service;
    private boolean changed;

    @FXML private Label infoLabel;

    @FXML private TextField idField;
    @FXML private TextField serialField;
    @FXML private TextField vendorField;
    @FXML private TextField modelField;
    @FXML private TextField dateField;
    @FXML private TextField priceField;

    private Notebook notebook;

    public final String CHANGE_INFO = "Change info that you want, then click Refresh button";
    public final String TYPE_ID = "Type ID, then click \"show info\"";

    @Override
    public void setService(NotebookService service) {
        this.service = service;
    }

    @Override
    public boolean isChanged() {
        return changed;
    }

    @FXML
    public void showInfo() {
        Long id = InputDataChecker.checkLong(idField);

        if (id != null) {
            notebook = service.find(id);
            if (notebook != null) {
                serialField.setText(notebook.getSerial());
                vendorField.setText(notebook.getVendor());
                modelField.setText(notebook.getModel());
                dateField.setText("" + notebook.getManufDate());
                priceField.setText("" + notebook.getPrice());

                serialField.setDisable(false);
                vendorField.setDisable(false);
                priceField.setDisable(false);

                // for ability to copy text
                modelField.setDisable(false);
                dateField.setDisable(false);

                infoLabel.setText(CHANGE_INFO);
            }
        }
    }

    @FXML
    public void changeInfo() {
        String serial;
        String vendor;
        Double price;
        Boolean changed = false;
        if (notebook != null) {
            if ((serial = InputDataChecker.checkString(serialField)) != null && !serial.equals(notebook.getSerial())) {
                notebook.setSerial(serial);
                changed = true;
            }
            if ((vendor = InputDataChecker.checkString(vendorField)) != null && !vendor.equals(notebook.getVendor())) {
                notebook.setVendor(vendor);
                changed = true;
            }
            if ((price = InputDataChecker.checkDouble(priceField)) != null && !price.equals(notebook.getPrice())) {
                notebook.setPrice(price);
                changed = true;
            }
            if (changed) {
                service.update(notebook);
                this.changed = true;

                serialField.setText("");
                vendorField.setText("");
                modelField.setText("");
                dateField.setText("");
                priceField.setText("");

                serialField.setDisable(true);
                vendorField.setDisable(true);
                priceField.setDisable(true);

                modelField.setDisable(true);
                dateField.setDisable(true);



                infoLabel.setText(TYPE_ID);
            }
        }
    }

}
