package pl.weatherApp.model.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class ValidationTest {

    @Test
    public void ifGivenTextIsEmptyReturnException(){
        //given
        Validation validation = new Validation();
        String city = "";
        String city2 = "  ";

        //when
        //then
        assertThat( validation.textValidation(city),is(false));
        assertThat( validation.textValidation(city2),is(false));
    }

    @ParameterizedTest
    @CsvSource({"23","1 Kraków ", "Kraków 1","Kraków12", "12Kraków","Los 12Angeles"})
    public void ifGivenTextContainNumbersReturnException(String city){
        //given
        Validation validation = new Validation();

        //when
        Boolean result = validation.textValidation(city);
        //then
        assertThat(result,is(false));
    }

    @ParameterizedTest
    @CsvSource({"Warszawa","Kraków", "Los Angeles"})
    public void givenTextShouldNotBeEmptyOrContainNumbers(String city){
        //given
        Validation validation = new Validation();
        //when
        Boolean result = validation.textValidation(city);

        //then
        assertThat(result,is(true));
    }

    @ParameterizedTest
    @CsvSource({"Warszawa   ","    Warszawa"})
    void spacesInTextFieldShouldBeRemovedAndReturnCorrectedText(String city){
        //given
        Validation validation = new Validation();
        //when
        Boolean result = validation.textValidation(city);

        //then
        assertThat(result,is(true));
    }
}