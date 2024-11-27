package seminar.accuweather;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public abstract class AccuweatherAbstractTest {

    static Properties prop = new Properties();
    private static String apiKey;
    private static String baseUrl;
    private String id;

    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Путь к файлу конфигурации
        try (InputStream configFile = Files.newInputStream(Path.of("src/test/resources/accuweather.properties"))) {
            prop.load(configFile);
        }

        apiKey = prop.getProperty("apikey");
        baseUrl = prop.getProperty("base_url");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

}
