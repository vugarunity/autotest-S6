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
public class RegionListTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("Поиск и проверка RegionList для конкретного региона")
    @Description("Проверяет, что API возвращает список регионов по запросу RegionList")
    @Link("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Получение данных RegionList для поиска региона")
    @Owner("Ализаде Вугар")
    void testRegion() {

        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "/locations/v1/regions")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".");

        Assertions.assertEquals(10, result.size());
    }

}
