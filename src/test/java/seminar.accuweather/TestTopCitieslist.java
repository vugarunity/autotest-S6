package seminar.accuweather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import static io.restassured.RestAssured.given;


import java.util.List;

public class TestTopCitieslist extends AccuweatherAbstractTest{

    @Test
    void testTopCities_100() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/100")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(100, result.size());
    }

    @Test
    void testTopCities_150() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/150")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(150, result.size());
    }
}
