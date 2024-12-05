package seminar.accuweather;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class LocationTest extends AccuweatherAbstractTest {

    @Test
    @DisplayName("Тест LocationTest - поиск объекта Location")
    @Description("Данный тест предназначен для поиска Location по ключу Baku")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта Location для Baku")
    @Owner("Ализаде Вугар")
    void testLocationBaku() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Baku")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(10, result.size());
    }

    @Test
    @DisplayName("Тест LocationTest - поиск объекта Location")
    @Description("Данный тест предназначен для поиска Location по ключу Novosibirsk")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Получение объекта Location для Baku")
    @Owner("Ализаде Вугар")
    void testLocationNovosibirsk() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Novosibirsk")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(3, result.size());
    }

}
