package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.weatherApp.model.client.CurrentWeather;
import pl.weatherApp.model.client.Localization;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;

import java.io.IOException;

public class MainController {

    @FXML
    private SideMenuController sideMenuController;
    @FXML
    private BorderPane borderPane;

    private CurrentWeather currentWeather;
    private Localization localization;
    @FXML
    public void initialize(){
        sideMenuController.setMainController(this);
        this.currentWeather = new CurrentWeather();
//        currentWeather.init();
        this.localization = new Localization();
        localization.init();

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
