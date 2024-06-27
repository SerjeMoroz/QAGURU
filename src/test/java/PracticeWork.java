import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


import Hooks.JUnitExamples;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PracticeWork extends JUnitExamples {


    public static void enterRandomFirstName(SelenideElement field, String randomFirstName) {

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomFirstName);

        assert field.getValue().equals(randomFirstName) : "Поле ввода не содержит текст: " + randomFirstName;
    }

    public static void enterRandomLastName(SelenideElement field, String LastName) {

        Faker faker = new Faker();
        String randomLastName = faker.name().lastName();

        field.shouldBe(enabled, Duration.ofSeconds(10));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        field.setValue(randomLastName);

        assert field.getValue().equals(randomLastName) : "Поле ввода не содержит текст: " + randomLastName;

    }

    public static void enterRandomEmail(SelenideElement field, String randomEmailAddress) {
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
        Faker faker = new Faker();
        String randomFirstName = faker.name().fullName();
        String randomEmail = faker.internet().emailAddress();

        open("/elements");

        $(By.id("item-0")).click();
        SelenideElement nameField = $(By.id("userName"));
        enterRandomFirstName(nameField, randomFirstName);

        SelenideElement emailField = $(By.id("userEmail"));
        enterRandomEmail(emailField, randomEmail);

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

    public void findLocatorInTable(String column, String value) {
        assert  $(byXpath("//div[text()='" + column + "']/ancestor::div[@class='rt-table']//div[@class='rt-tr-group']//div[text()='" + value + "']")).is(visible, Duration.ofSeconds(10)) : "Значение " + value + "в " +column + "не найдено";
    }


    @Test
    public void testElementsWebtables() {
        Faker faker = new Faker();
        String randomFirstName = faker.name().firstName();
        String randomLastName = faker.name().lastName();
        String randomEmail = faker.internet().emailAddress();

        open("/webtables");

        // Добавляем неявное ожидание после загрузки страницы
        $(byId("addNewRecordButton")).click();
        $("#registration-form-modal").shouldHave(text("Registration Form"));

        SelenideElement firstNameField = $("#firstName");
        enterRandomFirstName(firstNameField, randomFirstName);

        SelenideElement lastNameField = $("#lastName");
        enterRandomLastName(lastNameField, randomLastName);

        SelenideElement emailField = $("#userEmail");
        enterRandomEmail(emailField, randomEmail);

        $("#age").setValue("54");
        $("#salary").setValue("545");
        $("#department").setValue("5454");
        $("#submit").click();

        // Добавляем неявное ожидание после отправки формы
        $(By.xpath("//h1[normalize-space()='Web Tables']")).shouldBe(visible);



        findLocatorInTable("First Name", randomFirstName);
////        $(byXpath("//div[@role='grid']")).shouldHave(text(firstNameField.getValue()));
////        $(byXpath("//div[contains(text(),'Last Name')]")).shouldHave(text(lastNameField.getValue()));
////        $(byXpath("//div[contains(text(),'Email')]")).shouldHave(text(emailField.getValue()));
////        $(byXpath("//div[contains(text(),'Age')]")).shouldHave(value("54"));
////        $(byXpath("//div[contains(text(),'Salary')]")).shouldHave(value("545"));
////        $(byXpath("//div[normalize-space()='']")).shouldHave(value("5454"));




//    @Test
//    public void testElementsClicks() {
//
//        open("/buttons");
//
//        $("#doubleClickBtn").doubleClick();
//        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
//    }
    }
}//div[@class='rt-tr-group']//div[text()='Cierra']