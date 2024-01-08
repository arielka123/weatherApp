package pl.weatherApp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import pl.weatherApp.model.WeatherCollection;
import pl.weatherApp.model.service.WeatherServiceFactory;
import pl.weatherApp.model.utils.TextValidation;
import pl.weatherApp.view.ViewFactory;

public class ForecastWeatherController {

    @FXML
    private ChoiceBox<Integer> choiceBoxId;

    @FXML
    private Button showButton;
    @FXML
    private TextField inputCityId;
    @FXML
    private TilePane tilePaneId;

    @FXML
    public void initialize(){
        clear();
        setItemsInChoiceBox();
        showButton.disableProperty().bind(this.inputCityId.textProperty().isEmpty());
        showButton.disableProperty().bind(this.choiceBoxId.valueProperty().isNull());
        choiceBoxId.setValue(5);
    }

    @FXML
    public void showOnAction() {
        clear();
        int days = Integer.parseInt(choiceBoxId.getSelectionModel().getSelectedItem().toString());

        if (days != 0) {
            WeatherCollection weatherCollection;
            WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();
            ViewFactory viewFactory = new ViewFactory();

            if (TextValidation.inputValidation(inputCityId)) {
                weatherCollection = weatherServiceFactory.createForecastDays(inputCityId.getText());
                viewFactory.createForecastView(weatherCollection, days,tilePaneId);
            }
        }
    }

    private void clear() {
        tilePaneId.getChildren().clear();
    }
    private void setItemsInChoiceBox() {
        choiceBoxId.setItems(FXCollections.observableArrayList(
                5, 10, 15
        ));
    }
}
