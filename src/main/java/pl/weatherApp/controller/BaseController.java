package pl.weatherApp.controller;

import pl.weatherApp.model.service.WeatherServiceManager;
import pl.weatherApp.view.ViewManager;

public abstract class BaseController {
    protected WeatherServiceManager weatherServiceManager;
    protected ViewManager viewManager;

    protected BaseController() {
        weatherServiceManager = WeatherServiceManager.init();
        viewManager = ViewManager.init();
    }
}
