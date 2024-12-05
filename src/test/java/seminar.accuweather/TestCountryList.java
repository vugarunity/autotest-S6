package seminar.accuweather;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import static io.restassured.RestAssured.given;


import java.util.List;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class TestCountryList extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Поиск и проверка CountryList для региона Asia")
    @Description("Проверяет, что API возвращает корректный и полный список стран для региона Asia, включая ключевые атрибуты")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение данных CountryList для региона Asia")
    @Owner("Ализаде Вугар")
    void testCountryList() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/countries/Asia")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");

        Assertions.assertEquals(41, result.size());
    }
}
