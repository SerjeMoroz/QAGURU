package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import tests.TestBase;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage extends TestBase {
    private final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal  = new RegistrationResultsModal();

    private final SelenideElement
            FIRST_NAME_INPUT = $("#firstName"),
            LAST_NAME_INPUT = $("#lastName"),
            EMAIL_INPUT_FIELD = $("#userEmail"),
            GENDER_RADIO_BUTTON = $("label[for='gender-radio-1']"),
            MOBILE_NUMBER_INPUT = $("#userNumber"),
            DATE_OF_BIRTH = $("#dateOfBirthInput"),
            SUBJECTS_INPUT = $("#subjectsContainer input"),
                    ;



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage SetFirstName(String nameFirst){
        FIRST_NAME_INPUT.setValue(nameFirst);

        return this;
    }

    public RegistrationPage SetLastName(String nameLast){
        LAST_NAME_INPUT.setValue(nameLast);
        return this;
    }

    public RegistrationPage clearLastName() {
        LAST_NAME_INPUT.clear();
        return this;
    }

    public RegistrationPage setEmail(String email) {
        EMAIL_INPUT_FIELD.setValue(email); // todo move to Selenide elements
        return this;
    }

    public RegistrationPage setGender(String gender) {
        GENDER_RADIO_BUTTON.click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        MOBILE_NUMBER_INPUT.setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        DATE_OF_BIRTH.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInfo(String userSubjects) {
        SUBJECTS_INPUT.setValue(userSubjects);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
       registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


}
