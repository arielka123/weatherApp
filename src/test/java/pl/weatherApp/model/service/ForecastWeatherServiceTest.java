package pl.weatherApp.model.service;

import org.junit.jupiter.api.Test;
import pl.weatherApp.model.objects.Location;
import pl.weatherApp.model.objects.collections.ForecastCollection;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ForecastWeatherServiceTest {

    @Test
    void initShouldReturnCode200() {
        //given
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
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
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
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
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
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