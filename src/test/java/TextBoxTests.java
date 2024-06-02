import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests extends JUnitExapmles{


    @Test
   void fillFormTest() {

        open("/text-box");

        $("#userName").setValue("Sergei Moroz");
        $("#userEmail").setValue("sergei.moroz94test@gmail.com");
        $("#currentAddress").setValue("pushkina-kolotushkina");
        $("#permanentAddress").setValue("pushkina-kolotushkina2");
        $("#submit").click();

        $("#output").shouldHave(text("Sergei Moroz"),
                text("sergei.moroz94test@gmail.com"),
                text("pushkina-kolotushkina"),
                text("pushkina-kolotushkina2"));
    }

}
