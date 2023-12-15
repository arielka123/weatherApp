module pl.weatherApp.Main {
    requires javafx.controls;
    requires javafx.graphics;
    requires  javafx.fxml;

    opens pl.weatherApp to javafx.fxml;
    exports pl.weatherApp;
    exports  pl.weatherApp.controller;
}