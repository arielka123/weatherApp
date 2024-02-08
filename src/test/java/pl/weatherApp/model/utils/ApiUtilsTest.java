package pl.weatherApp.model.utils;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApiUtilsTest {
    @Test
    void exceptionShouldBeThrownWhenConnectionHasWrongURL()  {
        //given
        //when
        //then
        assertThrows(MalformedURLException.class, ()->ApiUtils.getHttpURLConnection(new URL("ads")));
    }
}