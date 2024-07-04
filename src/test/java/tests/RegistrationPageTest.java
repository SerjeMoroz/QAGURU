
package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static examples.Constants.*;

public class RegistrationPageTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormTest() {
        registrationPage.openPage()
                .setFirstName(nameFirst)
                .setLastName(nameLast)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userPhone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjectsInfo(userSubjects)
                .setHobbies()
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()
                .verifyResult("Student name", nameFirst + " " + nameLast)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}
