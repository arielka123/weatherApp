module pl.weatherApp.Main {
    requires javafx.controls;
    requires javafx.graphics;
    requires  javafx.fxml;
    requires json.simple;

    opens pl.weatherApp to javafx.fxml;
    opens pl.weatherApp.controller to javafx.fxml;

    exports pl.weatherApp;
    exports  pl.weatherApp.controller;
}