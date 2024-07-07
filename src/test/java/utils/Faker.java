package utils;

@SuppressWarnings("ALL")
public class Faker {

    public static net.datafaker.Faker faker = new net.datafaker.Faker();

    public static String getPassword = "1234";

    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generateFirstName() {
        return "Test_" + faker.name().firstName();
    }

    public static String generateLastname() {
        return faker.name().lastName();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateTitle() {
        return faker.app().name() + " #" + generateDecimalNumber();
    }

    public static String generateText() {
        return faker.lorem().sentence();
    }

    public static String generateDecimalNumber() {
        double decimalNumber =  faker.number().randomDouble(3, 1, 1000);
        String decimalNum = String.format("%.3f", decimalNumber);
        return decimalNum;
    }
}