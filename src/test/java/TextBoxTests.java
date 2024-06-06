import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests extends JUnitExamples{



    @Test
    public void practiceFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Moroz");
        $("#userEmail").setValue("alberich@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(byXpath("//div[@class='react-datepicker__day react-datepicker__day--029 react-datepicker__day--weekend']")).click();
        $("label[for='hobbies-checkbox-3']").click();
        $(byXpath("//input[@id='uploadPicture']")).uploadFile(new File("images/picture.png"));
        $("#currentAddress").setValue("Ne skajy");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(By.id("react-select-4-option-1")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[normalize-space()='Sergei Moroz']")).shouldHave(text("Sergei Moroz"));
        $(byXpath("//td[normalize-space()='alberich@gmail.com']")).shouldHave(text("alberich@gmail.com"));
        $(byXpath("//td[normalize-space()='8005553535']")).shouldHave(text("8005553535"));
        $(byXpath("//td[normalize-space()='29 January,1994']")).shouldHave(text("29 January,1994"));
        $(byXpath("//td[normalize-space()='picture.png']")).shouldHave(text("picture.png"));
        $(byXpath("//td[normalize-space()='Ne skajy']")).shouldHave(text("Ne skajy"));
        $(byXpath("//td[normalize-space()='Uttar Pradesh Lucknow']")).shouldHave(text("Uttar Pradesh Lucknow"));
        $("#closeLargeModal").click();

    }


}
