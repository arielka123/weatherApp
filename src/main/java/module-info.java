module pl.weatherApp.Main {
    requires javafx.controls;
    requires javafx.graphics;
    requires  javafx.fxml;
    requires json.simple;

    opens pl.weatherApp to javafx.fxml;
    opens pl.weatherApp.controller to javafx.fxml;

    exports pl.weatherApp;
    exports pl.weatherApp.controller;
    exports pl.weatherApp.view;
    exports pl.weatherApp.model.collections;
    exports pl.weatherApp.model.service;
    exports pl.weatherApp.model.service.objects;
    exports pl.weatherApp.model.utils;
}