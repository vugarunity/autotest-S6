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
public class TestOneDays extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест TestOneDays - поиск погоды за 1 день")
    @Description("Данный тест предназначен для получения данных о погоде за 1 день")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.NORMAL)
    @Story("Получение данных о погоде за 1 день")
    @Owner("Ализаде Вугар")
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
