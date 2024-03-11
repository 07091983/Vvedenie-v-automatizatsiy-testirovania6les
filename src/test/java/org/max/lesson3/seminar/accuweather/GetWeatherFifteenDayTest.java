package org.max.lesson3.seminar.accuweather;

import io.restassured.http.Method;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.lesson3.seminar.accuweather.weather.Weather;

import static io.restassured.RestAssured.given;

public class GetWeatherFifteenDayTest extends AccuweatherAbstractTest{

    @Test
    void get_fifteen_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401);
    }


}
