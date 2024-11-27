package seminar.accuweather;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestTenDays extends AccuweatherAbstractTest{

    @Test
    void testTenDaysBaku() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 27103)
                .when()
                .get(getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }

    @Test
    void testTenDaysNovosibirsk() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 294459)
                .when()
                .get(getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}

