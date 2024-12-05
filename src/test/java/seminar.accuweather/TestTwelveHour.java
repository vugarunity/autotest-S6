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
public class TestTwelveHour extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест TestTwelveHour - поиск погоды за 12 часов")
    @Description("Данный тест предназначен для получения данных о погоде за 12 часов для Новосибирска")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение данных о погоде за 12 часов")
    @Owner("Ализаде Вугар")
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
