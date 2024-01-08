package pl.weatherApp.controller;

import pl.weatherApp.view.ViewFactory;

public class StartViewController {

//    public static final String DAY_FXML = "/fxml/CurrentDay.fxml";
//    public static final String FORECAST_FXML = "/fxml/Forecast.fxml";
//    public static final String START_VIEW_FXML = "/fxml/StartView.fxml";
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void todayWeatherOnAction() {
        mainController.setCenter(ViewFactory.DAY_FXML);
    }

    public void weakWeatherOnAction() {
        mainController.setCenter(ViewFactory.FORECAST_FXML);
    }

    public void mainViewOnAction() {
        mainController.setCenter(ViewFactory.START_VIEW_FXML);
    }
}

