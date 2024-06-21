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

        Configuration.timeout = 10000;
        open("/automation-practice-form");

        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Moroz");
        $("#userEmail").setValue("alberich@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(byXpath("//div[@class='react-datepicker__day react-datepicker__day--029 react-datepicker__day--weekend']")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $(byXpath("//input[@id='uploadPicture']")).uploadFile(new File("images/picture.png"));
//        $("#uploadPicture").uploadFile(new File("images/picture.png"));
        $("#currentAddress").setValue("Ne skajy");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(By.id("react-select-4-option-1")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[text()='Student Name']/following-sibling::td")).shouldHave(text("Sergei Moroz"));
        $(byXpath("//td[text()='Student Email']/following-sibling::td")).shouldHave(text("alberich@gmail.com"));
        $(byXpath("//td[text()='Gender']/following-sibling::td")).shouldHave(text("Male"));
        $(byXpath("//td[text()='Mobile']/following-sibling::td")).shouldHave(text("1234567899"));
        $(byXpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text("29 January,1994"));
        $(byXpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text("picture.png"));
        $(byXpath("//td[text()='Address']/following-sibling::td")).shouldHave(text("Ne skajy"));
        $(byXpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Lucknow"));
        $("#closeLargeModal").click();

        //td[text()='Student Name']/following-sibling::td
    }

}
