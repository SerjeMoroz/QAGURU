import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.files.DownloadActions.click;



import Hooks.JUnitExamples;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class PracticeWorkAlertsFrameWindows extends JUnitExamples {

    @Test
    public void testsAlertsBrowserWindows() {

        open("/browser-windows");

        $("#tabButton").click();

        String originalTab = getWebDriver().getWindowHandle();

        switchTo().window(1);
        $("#sampleHeading").shouldHave(text("This is a sample page"));
        closeWindow();
        switchTo().window(originalTab);

        $("#windowButton").click();
        switchTo().window(1);
        $(byXpath("//h1[@id='sampleHeading']")).shouldHave(text("This is a sample page"));
        closeWindow();
        switchTo().window(originalTab);

        $("#messageWindowButton").click();
        switchTo().window(1);
        $("body").shouldHave(text("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        closeWindow();
        switchTo().window(originalTab);

    }

}
