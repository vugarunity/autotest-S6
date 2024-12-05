package seminar.accuweather;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class Test15Days extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Тест Test15Days - поиск погоды за 15 дней")
    @Description("Негативный тест предназначен для проверки данных о погоде за 15 дней для Новосибирска")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение данных о погоде за 15 дней")
    @Owner("Ализаде Вугар")
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

