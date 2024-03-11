package org.max.lesson3.seminar.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.lesson3.seminar.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetLocationTestBarnaul extends AccuweatherAbstractTest{

    @Test
    void getLocation_autocomplete_returnBarnaul() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/autocomplete?q=Barnaul")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .time(Matchers.greaterThan(200l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(2,response.size());
        Assertions.assertEquals("Barnaul", response.get(0).getLocalizedName());
    }
}

