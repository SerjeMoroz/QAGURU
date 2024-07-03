package tests;

import examples.JUnitExamples;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework_3 extends JUnitExamples {
    @Test
    public void hoverOnGithubPage() {
        open("https://github.com");
        $$((".HeaderMenu-link")).findBy(text("Solutions")).hover();
        $$((".HeaderMenu-dropdown-link")).findBy(text("Enterprise")).click();
        $(byText("The enterprise-ready platform that developers know and love.")).shouldBe(visible);
//        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
//        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
//        $(byText("Build like the best")).shouldBe(visible);
    }
}
