package seminar.accuweather;

import io.qameta.allure.*;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class OneHourTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест OneHourTest - поиск погоды за 1 час")
    @Description("Данный тест предназначен для получения данных о погоде за 1 час для Баку")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение данных о погоде за 1 час")
    @Owner("Ализаде Вугар")
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
