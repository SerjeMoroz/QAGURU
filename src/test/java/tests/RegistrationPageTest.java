package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.Faker;

import static examples.Constants.*;

public class RegistrationPageTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    private String email = Faker.generateEmail();
    private String firstName = Faker.generateFirstName();
    private String lastName = Faker.generateLastname();
    private String text = Faker.generateText();

    @Test
    void practiceFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(userPhone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjectsInfo(userSubjects)
                .setHobbies()
                .uploadPicture(picture)
                .setAddress(text)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", text)
                .verifyResult("State and City", state + " " + city)
                .closeModalForm();
    }
}

