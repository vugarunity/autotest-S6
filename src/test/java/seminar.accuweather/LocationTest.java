package seminar.accuweather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;


public class LocationTest extends AccuweatherAbstractTest {

    @Test
    void testLocationBaku() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Baku")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(10, result.size());
    }

    @Test
    void testLocationNovosibirsk() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Novosibirsk")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(3, result.size());
    }

}
