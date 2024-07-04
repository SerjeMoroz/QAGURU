// RegistrationPage.java
package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
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
            HOBBIES_RADIO_BUTTON = $("label[for='hobbies-checkbox-1']"),
            UPLOAD_PICTURE = $(byXpath("//input[@id='uploadPicture']")),
            ADDRESS_INPUT = $("#currentAddress"),
            STATE_CITY_INPUT = $("div[class=' css-yk16xz-control'] div[class=' css-1hwfws3']"),
            CITY_INPUT = $("div[id='stateCity-wrapper'] div:nth-child(3)"),
            SUBMIT_BUTTON = $("#submit"),
            CLOSE_MODAL_FORM_BUTTON = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String nameFirst) {
        FIRST_NAME_INPUT.setValue(nameFirst);
        return this;
    }

    public RegistrationPage setLastName(String nameLast) {
        LAST_NAME_INPUT.setValue(nameLast);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        EMAIL_INPUT_FIELD.setValue(email);
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
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationPage setSubjectsInfo(String userSubjects) {
        SUBJECTS_INPUT.setValue(userSubjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        HOBBIES_RADIO_BUTTON.click();
        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        UPLOAD_PICTURE.uploadFile(new File("images/picture.png"));
        return this;
    }

    public RegistrationPage setAddress(String address) {
        ADDRESS_INPUT.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        STATE_CITY_INPUT.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        CITY_INPUT.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage sendSubmitButton() {
        SUBMIT_BUTTON.click();
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

    public RegistrationPage closeModalForm() {
        CLOSE_MODAL_FORM_BUTTON.click();
        return this;
    }
}
