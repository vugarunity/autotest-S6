package seminar.accuweather;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class TestTenDays extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест TestTenDays - поиск погоды за 10 дней")
    @Description("Негативный тест предназначен для проверки данных о погоде за 10 дней для Баку")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение данных о погоде за 10 дней")
    @Owner("Ализаде Вугар")
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

