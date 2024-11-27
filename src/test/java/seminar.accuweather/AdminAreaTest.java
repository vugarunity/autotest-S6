package seminar.accuweather;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import static io.restassured.RestAssured.given;


import java.util.List;

public class AdminAreaTest extends AccuweatherAbstractTest{

    @Test
    void testAdminArea_AZ() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/adminareas/AZ")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");

        Assertions.assertEquals(78, result.size());
    }

    @Test
    void testAdminArea_RU() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/adminareas/RU")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(83, result.size());
    }
}
