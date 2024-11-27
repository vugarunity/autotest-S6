package seminar.accuweather;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TestOneDays extends AccuweatherAbstractTest {

    @Test
    public void testForecastBaku() {

        Response response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/1day/27103")
                .then()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(1, response.jsonPath().getList("DailyForecasts").size());
    }

    @Test
    public void testForecastNovosibirsk() {

        Response response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/daily/5day/294459")
                .then()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(5, response.jsonPath().getList("DailyForecasts").size());
    }
}
