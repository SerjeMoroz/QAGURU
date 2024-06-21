import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;


public class JUnitExamples {


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
//        Selenide.closeWindow();
//        Selenide.closeWebDriver();
    }

    @AfterAll
//  Выполняется один раз после всех тестов
    public static void afterAll() {
        clearBrowserLocalStorage();
        clearBrowserCookies();
        WebDriverRunner.getWebDriver().quit(); //quit browser
    }

}
