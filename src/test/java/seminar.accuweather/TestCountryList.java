package seminar.accuweather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import static io.restassured.RestAssured.given;


import java.util.List;

public class TestCountryList extends AccuweatherAbstractTest{

    @Test
    void testCountryList() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/countries/Asia")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");

        Assertions.assertEquals(41, result.size());
    }
}
