import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import Hooks.JUnitExamples;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PracticeWork extends JUnitExamples {


    public static void enterRandomFirstName(SelenideElement field) {

        Faker faker = new Faker();
        String randomFirstName = faker.name().fullName();

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomFirstName);

        assert field.getValue().equals(randomFirstName) : "Поле ввода не содержит текст: " + randomFirstName;
    }

    public static void enterRandomLastName(SelenideElement field) {

        Faker faker = new Faker();
        String randomLastName = faker.name().lastName();

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomLastName);

        assert field.getValue().equals(randomLastName) : "Поле ввода не содержит текст: " + randomLastName;

    }

    public static void enterRandomEmail(SelenideElement field) {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomEmail);

        assert field.getValue().equals(randomEmail) : "Поле ввода не содержит текст: " + randomEmail;
    }

    public static void enterRandomAddress(SelenideElement field) {
        Faker faker = new Faker();
        String randomAddress = faker.address().secondaryAddress();
        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomAddress);

        assert field.getValue().equals(randomAddress) : "Поле ввода не содержит текст: " + randomAddress;
    }

    public static void enterRandomPermanentAddress(SelenideElement field) {
        Faker faker = new Faker();
        String randomPernamentAddress = faker.address().fullAddress();

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomPernamentAddress);

        assert field.getValue().equals(randomPernamentAddress) : "Поле ввода не содержит текст: " + randomPernamentAddress;
    }


    @Test
    public void testElementsTextBox() {

        Configuration.timeout = 1000;

        open("/elements");

        $(By.id("item-0")).click();
        SelenideElement nameField = $(By.id("userName"));
        enterRandomFirstName(nameField);

        SelenideElement emailField = $(By.id("userEmail"));
        enterRandomEmail(emailField);

        SelenideElement currentAddressField = $(By.id("currentAddress"));
        enterRandomAddress(currentAddressField);

        SelenideElement pernamentAddressField = $(By.id("permanentAddress"));
        enterRandomPermanentAddress(pernamentAddressField);
        $(By.id("submit")).click();

        $(By.xpath("//p[@id='name']")).shouldHave(text(nameField.getValue()));
        $(By.xpath("//p[@id='email']")).shouldHave(text(emailField.getValue()));
        $(By.xpath("//p[@id='currentAddress']")).shouldHave(text(currentAddressField.getValue()));
        $(By.xpath("//p[@id='permanentAddress']")).shouldHave(text(pernamentAddressField.getValue()));
    }

    @Test
    public void testElementsCheckBox() {

        open("/checkbox");

        $("button[title='Expand all']").click();
        $(By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']")).click();
        $(By.xpath("//button[@title='Collapse all']//*[name()='svg']")).click();
        $(By.xpath("//div[@id='result']")).shouldHave(text("You have selected :"));
    }


    @Test
    public void testElementsRadioButton() {

        open("/radio-button");

        $(byText("Radio Button")).shouldHave(visible);

        // Список элементов для выбора
        List<String> radiolabels = List.of("yesRadio", "impressiveRadio");

        // Выбрать случайный элемент
        Random random = new Random();
        String randomRadioLabel = radiolabels.get(random.nextInt(radiolabels.size()));

        // Кликнуть случайный элемент
        $("label[for='" + randomRadioLabel + "']").click();

        // Проверить выбранный элемент
        String expectedText = randomRadioLabel.equals("yesRadio") ? "Yes" : "Impressive";
        $(byText("You have selected")).shouldHave(text(expectedText));
    }

    @Test
    public void testElementsWebtables() {

        open("/webtables");

        $(byId("addNewRecordButton")).click();
        $("#registration-form-modal").shouldHave(text("Registration Form"));

        SelenideElement firstNameField = $("#firstName");
        enterRandomFirstName(firstNameField);

        SelenideElement lastNameField = $("#lastName");
        enterRandomLastName(lastNameField);

        SelenideElement emailField = $("#userEmail");
        enterRandomEmail(emailField);

        $("#age").setValue("54");
        $("#salary").setValue("545");
        $("#department").setValue("5454");
        $("#submit").click();

        $(By.xpath("//h1[normalize-space()='Web Tables']")).shouldHave(text("Web Tables"));

        $(byXpath("//div[contains(text(),'First Name')]")).shouldHave(text(firstNameField.getValue()));
        $(byXpath("//div[contains(text(),'Last Name')]")).shouldHave(text(lastNameField.getValue()));
        $(byXpath("//div[contains(text(),'Email')]")).shouldHave(text(emailField.getValue()));
////        $(byXpath("//div[contains(text(),'Age')]")).shouldHave(value("54"));
////        $(byXpath("//div[contains(text(),'Salary')]")).shouldHave(value("545"));
//        $(byXpath("//div[normalize-space()='']")).shouldHave(value("5454"));

    }

}
