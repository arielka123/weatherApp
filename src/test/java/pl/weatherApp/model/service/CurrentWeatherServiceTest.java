package pl.weatherApp.model.service;

import org.junit.jupiter.api.Test;
import pl.weatherApp.model.objects.CurrentWeather;
import pl.weatherApp.model.objects.Location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CurrentWeatherServiceTest {

    @Test
    void initShouldReturnCode200(){
        //given
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        LocationService locationService = mock();
        Location location = mock();

        //when
        when(location.getCity()).thenReturn("Warszawa");
        when(locationService.init()).thenReturn(location);
        currentWeatherService.init(location);

        //then
        assertThat(currentWeatherService.getResponseCode(), is(200));
    }

    @Test
    void initShouldReturnCurrentWeather(){
        //given
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        LocationService locationService = mock();
        Location location = mock();

        //when
        when(location.getCity()).thenReturn("Warszawa");
        when(locationService.init()).thenReturn(location);
        CurrentWeather currentWeather = currentWeatherService.init(location);

        //then
        assertThat(currentWeather.getDescription(), notNullValue());
        assertThat(currentWeather.getTemp(), notNullValue());
    }
}