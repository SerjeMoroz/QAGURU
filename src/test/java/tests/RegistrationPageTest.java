package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageTest extends TestBase  {

    @Test
    void practiceFormTest() {
        String nameFirst = "Sergei";
        String nameLast = "Moroz";
        String userEmail = "alberich@gmail.com";
        String gender = "Male";
        String userPhone = "1234567899";
        String userSubjects = "Maths";


        registrationPage.openPage()
                .openPage()
                .SetFirstName(nameFirst)
                .SetLastName(nameLast)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userPhone)
                .setBirthDate("29", "January", "2008")
                .setSubjectsInfo(userSubjects)
                ;




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
        $(byXpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text("29 January,1994"));
        $(byXpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text("picture.png"));
        $(byXpath("//td[text()='Address']/following-sibling::td")).shouldHave(text("Ne skajy"));
        $(byXpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Lucknow"));

        registrationPage.verifyResultsModalAppears();
        registrationPage.verifyResult("Student name" ,nameFirst + "" + nameLast);
        registrationPage.verifyResult("Student Email", userEmail);
        registrationPage.verifyResult("Gender", gender);
        registrationPage.verifyResult("Mobile", userPhone);
        registrationPage.verifyResult("Date of Birth", "29 January,1994");
//        registrationPage.verifyResult()
        $("#closeLargeModal").click();

        //td[text()='Student Name']/following-sibling::td
    }
}
