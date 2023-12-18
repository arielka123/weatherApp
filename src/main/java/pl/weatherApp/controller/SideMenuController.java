package pl.weatherApp.controller;

public class SideMenuController {

    public static final String SETTINGS_FXML ="/fxml/Settings1.fxml";
    public static final String DAY_FXML = "/fxml/Day.fxml";
    public static final String WEEK_FXML = "/fxml/Week.fxml";
    public static final String MONTHS_FXML = "/fxml/Months.fxml";

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
}

