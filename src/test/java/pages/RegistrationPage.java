// RegistrationPage.java
package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static examples.Constants.*;

public class RegistrationPage {

    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    CalendarComponent calendarComponent = new CalendarComponent();


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
            STATE_FIELD = $(byText("Select State")),
            CITY_FIELD = $("#city"),
            SUBMIT_BUTTON = $("#submit"),
            CLOSE_MODAL_FORM_BUTTON = $("#closeLargeModal");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        FIRST_NAME_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        LAST_NAME_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EMAIL_INPUT_FIELD.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        GENDER_RADIO_BUTTON.click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        MOBILE_NUMBER_INPUT.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        DATE_OF_BIRTH.click();
        calendarComponent.setDate(day, month, year);
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
        UPLOAD_PICTURE.uploadFile(new File("images/" + picture));
        return this;
    }

    public RegistrationPage setAddress(String address) {
        ADDRESS_INPUT.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        STATE_FIELD.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        CITY_FIELD.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        SUBMIT_BUTTON.click();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage closeModalForm() {
        CLOSE_MODAL_FORM_BUTTON.click();
        return this;
    }
}
