package seminar.accuweather;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test15Days extends AccuweatherAbstractTest{

    @Test
    void testFifteenDayNovosibirsk() {

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

