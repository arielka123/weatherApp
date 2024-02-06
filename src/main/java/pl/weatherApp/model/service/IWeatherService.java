package pl.weatherApp.model.service;
import pl.weatherApp.model.objects.Location;

public interface IWeatherService {
    Object init(Location location);
}
