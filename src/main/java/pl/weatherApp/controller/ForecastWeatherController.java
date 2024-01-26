package pl.weatherApp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import pl.weatherApp.model.collections.WeatherCollection;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Validation;

public class ForecastWeatherController extends BaseController {

    @FXML
    private ChoiceBox<Integer> choiceBoxId;
    @FXML
    private Button showButton;
    @FXML
    private TextField inputCityId;
    @FXML
    private TilePane tilePaneId;
    @FXML
    private Label countryCode;

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
            Validation validation = new Validation();
            if (validation.textValidation(inputCityId.getText())) {
                weatherCollection = weatherServiceManager.createForecast(inputCityId.getText());
                viewManager.createForecastView(weatherCollection, days,tilePaneId, countryCode);
            }
            else DialogUtils.inputDialog();
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
