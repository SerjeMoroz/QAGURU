import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Cleanup;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;


public class JUnitExapmles {


    @BeforeAll
//  Выполняется один раз перед всеми тестами
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        System.out.println("Here is beforeAll()");
    }

    @BeforeEach
//  Выполняется перед каждым тестом
    public void beforeEach() {
        System.out.println("Here is beforeEach()");
    }

    @AfterEach
//  Выполняется после каждого теста
    public void afterEach() {

    }

    @AfterAll
//  Выполняется один раз после всех тестов
    public static void afterAll() {
        clearBrowserLocalStorage();
        clearBrowserCookies();
        WebDriverRunner.getWebDriver().quit();
    }

}
