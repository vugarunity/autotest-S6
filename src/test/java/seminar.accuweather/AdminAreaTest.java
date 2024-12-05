package seminar.accuweather;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import static io.restassured.RestAssured.given;


import java.util.List;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class AdminAreaTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Поиск AdminArea для страны AZ")
    @Description("Проверяет, что API возвращает полный список административных областей AdminArea для страны AZ")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение объекта AdminArea для AZ")
    @Owner("Ализаде Вугар")
    void testAdminArea_AZ() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/adminareas/AZ")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");

        Assertions.assertEquals(78, result.size());
    }

    @Test
    @DisplayName("Поиск AdminArea для страны RU")
    @Description("Проверяет, что API возвращает полный список административных областей AdminArea для страны RU")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение объекта AdminArea для RU")
    @Owner("Ализаде Вугар")
    void testAdminArea_RU() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/adminareas/RU")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");


        Assertions.assertEquals(83, result.size());
    }
}
