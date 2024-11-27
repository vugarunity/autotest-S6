package seminar.accuweather;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TestTwelveHour extends AccuweatherAbstractTest {

    @Test
    public void testHourlyForecastNovosibirsk() {

        Response response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/hourly/12hour/294459")
                .then()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(12, response.jsonPath().getList(".").size());

        String temperature = response.jsonPath().getString("[0].Temperature.Value");

        Assertions.assertNotNull(temperature);
    }

}
