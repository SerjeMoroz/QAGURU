import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests extends JUnitExapmles{


//    @Test
//   void fillFormTest() {
//
//        open("/text-box");
//
//        $("#userName").setValue("Sergei Moroz");
//        $("#userEmail").setValue("sergei.moroz94test@gmail.com");
//        $("#currentAddress").setValue("pushkina-kolotushkina");
//        $("#permanentAddress").setValue("pushkina-kolotushkina2");
//        $("#submit").click();
//
//        $("#output").shouldHave(text("Sergei Moroz"),
//                text("sergei.moroz94test@gmail.com"),
//                text("pushkina-kolotushkina"),
//                text("pushkina-kolotushkina2"));
//    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Sergei");
        $("#lastName").setValue("Moroz");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("296506882");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1994")).click();
        $(".react-datepicker__month-container").$(byText("29")).click();
        $("label[for='hobbies-checkbox-3']").click();
//        $("#uploadPicture").uploadFromClasspath("images/Screenshot_1.png");
        $("#currentAddress").setValue("Ne skajy");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();

    }


}
