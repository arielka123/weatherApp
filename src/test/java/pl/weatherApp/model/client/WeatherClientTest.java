package pl.weatherApp.model.client;

import org.junit.jupiter.api.Test;
import pl.weatherApp.model.service.objects.Location;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WeatherClientTest {

    @Test
    void getLocationURLShouldReturnProperURL(){
        //given
       URL url = WeatherClient.getLocationURL("Warszawa");

        //then
        assertThat(url.toString(), is("https://api.openweathermap.org/geo/1.0/direct?q=Warszawa&limit=1&appid=b51b675a883e8283a7d53f406655823b"));
    }

    @Test
    void getCurrentWeatherURLShouldReturnProperURL(){
        //given
        Location location = new Location();
        location.setCity("Warszawa");
        URL url = WeatherClient.getCurrentWeatherURL(location);

        //then
        assertThat(url.toString(), is("https://api.openweathermap.org/data/2.5/weather?q=Warszawa&appid=b51b675a883e8283a7d53f406655823b&lang=pl&units=metric"));
    }

    @Test
    void getForecastWeatherURLShouldReturnProperURL(){
        //given
        Location location = new Location();
        location.setCity("Warszawa");
        URL url = WeatherClient.getForecastURL(location);

        //then
        assertThat(url.toString(), is("https://api.open-meteo.com/v1/forecast?latitude=null&longitude=null&daily=weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,precipitation_sum,wind_speed_10m_max,wind_direction_10m_dominant&timezone=auto&forecast_days=16"));
    }

}