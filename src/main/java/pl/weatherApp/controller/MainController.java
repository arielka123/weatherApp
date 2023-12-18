package pl.weatherApp.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.weatherApp.model.Utils.DialogUtils;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private SideMenuController sideMenuController;
    @FXML
    private BorderPane borderPane;

    @FXML
    public void initialize(){
        sideMenuController.setMainController(this);
    }

    public void setCenter(String Path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path));

        loader.setResources(ResourceBundle.getBundle("bundle.message"));
        try {
            borderPane.setCenter(loader.load());
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
