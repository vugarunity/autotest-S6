package seminar.accuweather;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class OneHourTest extends AccuweatherAbstractTest {

    @Test
    public void testHourlyForecastBaku() {

        Response response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/forecasts/v1/hourly/1hour/27103")
                .then()
                .statusCode(200)
                .extract().response();

        Assertions.assertEquals(1, response.jsonPath().getList(".").size());

        String temperature = response.jsonPath().getString("[0].Temperature.Value");

        Assertions.assertNotNull(temperature);
    }

}
