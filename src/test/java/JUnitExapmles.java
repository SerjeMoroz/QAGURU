import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


public class JUnitExapmles {


    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        System.out.println("Here is beforeAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Here is beforeEach()");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("Here is afterAll");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Here is afterEach");
    }

    @Test
    void firstTest() {
        System.out.println("    Here is firstTest()");
    }

    @Test
    void secondTest() {
        System.out.println("    Here is secondTest()");
    }
}
