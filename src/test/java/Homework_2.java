import Hooks.JUnitExamples;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class Homework_2 extends JUnitExamples {

    @Test
    public void openGithubPages() {
        //Open GitHub page
        open ("https://github.com");
        //click search field
        $("span[class='flex-1']").click();
        //enter value Selenide
        $("#query-builder-test").setValue("Selenide").pressEnter();
        sleep(500);
        //Find first repositories selenide/selenide
        $(byXpath("(//span[@class='Text-sc-17v1xeu-0 qaOIC search-match'])[1]")).click();
        sleep(500);
        //Go to the Wiki page
        $("#wiki-tab").click();
        //Find element "Soft assertions"
        $("#wiki-wrapper").shouldHave(text("Soft assertions"));
        //Click link Soft assertions
        $(byText("Soft assertions")).click();
        //Find example JUnit5 code
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
