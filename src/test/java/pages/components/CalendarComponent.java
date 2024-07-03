package pages.components;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(byXpath("//div[@class='react-datepicker__day react-datepicker__day--0" + day
                + ": react-datepicker__day--weekend']")).click();
    }
}
