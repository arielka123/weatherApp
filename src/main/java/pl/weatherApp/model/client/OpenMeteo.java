package pl.weatherApp.model.client;

import pl.weatherApp.model.service.LocalizationService;

public class OpenMeteo {
    public static String forecastURL ="https://api.open-meteo.com/v1/forecast?latitude="+LocalizationService.getLatitude()+"&longitude="+ LocalizationService.getLongitude() +"&daily=weather_code,temperature_2m_max,apparent_temperature_max,precipitation_sum,wind_speed_10m_max,wind_direction_10m_dominant&timezone=auto&forecast_days=16";

//    public static String forecastURL ="https://api.open-meteo.com/v1/forecast?latitude=52.22977&longitude=21.01178&daily=weather_code,temperature_2m_max,apparent_temperature_max,precipitation_sum,wind_speed_10m_max,wind_direction_10m_dominant&timezone=auto&forecast_days=16";
}
