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
public class TestTopCitieslist extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Проверка списка TopCities - топ-100 городов")
    @Description("Проверяет, что API возвращает список из 100 топовых городов по запросу TopCities")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение списка TopCities - топ-100 городов")
    @Owner("Ализаде Вугар")
    void testTopCities_100() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/100")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(100, result.size());
    }

    @Test
    @DisplayName("Проверка списка TopCities - топ-150 городов")
    @Description("Проверяет, что API возвращает список из 150 топовых городов по запросу TopCities")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение списка TopCities - топ-150 городов")
    @Owner("Ализаде Вугар")
    void testTopCities_150() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/150")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(150, result.size());
    }
}
