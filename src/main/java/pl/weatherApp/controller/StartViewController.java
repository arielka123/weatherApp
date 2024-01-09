package pl.weatherApp.controller;

import pl.weatherApp.view.ViewFactory;

public class StartViewController {
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

