package pl.weatherApp.controller;

import pl.weatherApp.model.service.WeatherServiceFactory;
import pl.weatherApp.view.ViewFactory;

public abstract class BaseController {
    protected  WeatherServiceFactory weatherServiceFactory;
    protected  ViewFactory viewFactory;

    protected BaseController() {
        weatherServiceFactory = WeatherServiceFactory.init();
        viewFactory = ViewFactory.init();
    }
}
