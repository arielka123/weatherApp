package pl.weatherApp.model.service;

import org.junit.jupiter.api.Test;
import pl.weatherApp.model.objects.Location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationServiceTest {

    @Test
    void initShouldReturnLocation(){
        //given
        LocationService locationService = new LocationService("Warszawa");

        //when
        Location result = locationService.init();

        //then
        assertThat(result.getCity(), is("Warszawa"));
        assertThat(result.getCountry_code(), is("PL"));
        assertThat(locationService.getResponseCode(), is(200));
    }

    @Test
    void exceptionShouldBeThrownIfCityIsEmpty(){
        //given
        LocationService locationService = new LocationService("");

        //when
        //then
        assertThrows(RuntimeException.class, locationService::init);
        assertThat(locationService.getResponseCode(), is(400));
    }

    @Test
    void exceptionShouldBeThrownIfCityHasWrongName(){
        //given
        String city = "asd 123";
        LocationService locationService = new LocationService(city);

        //when
        Location location = locationService.init();

        //then
        assertThat(locationService.getResponseCode(), is(200));
        assertThat(location.getCity(), is(not(city)));
    }

}