package pl.weatherApp.controller;

public class SideMenuController {

    public static final String SETTINGS_FXML ="/fxml/Settings.fxml";
    public static final String DAY_FXML = "/fxml/CurrentDay.fxml";
    public static final String WEEK_FXML = "/fxml/5days.fxml";
    public static final String MONTHS_FXML = "/fxml/16days.fxml";
    public static final String START_VIEW_FXML = "/fxml/StartView.fxml";


    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void todayWeatherOnAction() {
        mainController.setCenter(DAY_FXML);
    }

    public void weakWeatherOnAction() {
        mainController.setCenter(WEEK_FXML);
    }

    public void monthsWeatherOnAction() {
        mainController.setCenter(MONTHS_FXML);
    }

    public void settingsOnAction() {
        mainController.setCenter(SETTINGS_FXML);
    }

    public void mainViewOnAction() {
        mainController.setCenter(START_VIEW_FXML);
    }
}

