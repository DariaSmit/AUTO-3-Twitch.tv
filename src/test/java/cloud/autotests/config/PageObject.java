package cloud.autotests.config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    CalendarComponent calendarComponent = new CalendarComponent();


    public PageObject openPage() {
        Selenide.open("https://www.twitch.tv");
        return this;
    }

    public PageObject assertHeader(String result) {
        $(".top-nav__overflow-menu").shouldHave(Condition.text(result));
        return this;
    }

    public PageObject assertMiniHeader(String result) {
        $(".kitt-header__extra").shouldHave(Condition.text("result"));
        return this;
    }
    public PageObject setBirthDate(String day, String month, String year) {
        $("#birthday-picker__input").click();
        calendarComponent.setDate(day, month, year);
        return this;
}
}


