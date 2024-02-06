package pl.weatherApp.model.service;

import org.junit.jupiter.api.Test;
import pl.weatherApp.model.objects.collections.ForecastCollection;
import pl.weatherApp.model.objects.Location;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ForecastWeatherServiceTest {

    @Test
    void exceptionShouldBeThrownWhenConnectionHasWrongURL() {
        //given
        ForecastWeatherWeatherService forecastWeatherService  = new ForecastWeatherWeatherService();

        //when
        //then
        assertThrows(MalformedURLException.class, ()->forecastWeatherService.getHttpURLConnection(new URL("ads")));
    }

    @Test
    void initShouldReturnCode200() {
        //given
        ForecastWeatherWeatherService forecastWeatherService = new ForecastWeatherWeatherService();
        LocationService locationService = mock();
        Location location = mock();

        //when
        when(location.getCity()).thenReturn("Warszawa");
        when(locationService.init()).thenReturn(location);
        forecastWeatherService.init(location);

        //then
        assertThat(forecastWeatherService.getResponseCode(), is(200));

    }
    @Test
    void initShouldReturnForecastWeather(){
        //given
        ForecastWeatherWeatherService forecastWeatherService = new ForecastWeatherWeatherService();
        LocationService locationService = mock();
        Location location = mock();
        LocalDate currentDate = LocalDate.now();

        //when
        when(location.getCity()).thenReturn("Warszawa");
        when(locationService.init()).thenReturn(location);
        ForecastCollection forecastCollection = forecastWeatherService.init(location);

        //then
        assertThat(forecastCollection.getOneOfForecastList(0).getDateStr(), is(currentDate.toString()));
    }

    @Test
    void forecastShouldHaveWeatherFor16Days(){
        //given
        ForecastWeatherWeatherService forecastWeatherService = new ForecastWeatherWeatherService();
        LocationService locationService = mock();
        Location location = mock();
        //when
        when(location.getCity()).thenReturn("Warszawa");
        when(locationService.init()).thenReturn(location);
        ForecastCollection forecastCollection = forecastWeatherService.init(location);

        //then
        assertThat(forecastCollection.getOneOfForecastList(15), is(notNullValue()));
        assertThat(forecastCollection.getForecastList().size(), is(16));
    }
}