package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;

import java.io.IOException;

public class MainController {

    @FXML
    private SideMenuController sideMenuController=null;
    @FXML
    private BorderPane borderPane;

    @FXML
    public void initialize(){
        sideMenuController.setMainController(this);
//        WeatherServiceFactory.createWeatherService();
    }

    public void setCenter(String Path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Path));

        loader.setResources(FxmlUtils.getResourceBundle());
        try {
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
