package fx.project.controller;

import fx.project.main.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;

public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    public void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
    }

    @FXML
    public void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml"
        );
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }

    @FXML
    public void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile == null) {
            handleSaveAs();
        } else {
            mainApp.savePersonDataToFile(personFile);
        }
    }

    @FXML
    public void handleSaveAs(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml"
        );
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.savePersonDataToFile(file);
        }

    }

    @FXML
    public void handleAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AddressApp");
        alert.setHeaderText("About");
        alert.setContentText("Some information");

        alert.showAndWait();
    }

    @FXML
    public void handleExit(){
        System.exit(0);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
