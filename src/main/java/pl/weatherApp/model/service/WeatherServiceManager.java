package pl.weatherApp.model.service;

import pl.weatherApp.model.objects.Location;

public class WeatherServiceManager {

    private static WeatherServiceManager instance;
    private WeatherServiceManager(){
        instance = this;
    }

    public static WeatherServiceManager init() {
        if (instance == null) {
            instance = new WeatherServiceManager();
        }
        return instance;
    }

    public  Object createWeather(String city, IService service){
        Location location = createLocalization(city);
        return service.init(location);
    }

    private Location createLocalization(String city){
        LocationService localizationService= new LocationService(city);
        return localizationService.init();
    }
}
