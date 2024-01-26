package pl.weatherApp.controller;

import pl.weatherApp.view.ViewManager;

public class StartViewController {
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void todayWeatherOnAction() {
        mainController.setCenter(ViewManager.DAY_FXML);
    }

    public void weakWeatherOnAction() {
        mainController.setCenter(ViewManager.FORECAST_FXML);
    }

    public void mainViewOnAction() {
        mainController.setCenter(ViewManager.START_VIEW_FXML);
    }
}

