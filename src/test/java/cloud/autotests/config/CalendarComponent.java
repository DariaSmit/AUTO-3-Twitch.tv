package cloud.autotests.config;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".Layout-sc-nxg1ff-0 birthday-picker__input").selectOption(month);
        $(".Layout-sc-nxg1ff-0 birthday-picker__input").selectOption(year);
        $(".Layout-sc-nxg1ff-0 birthday-picker__input" + day +
                ":not(.Layout-sc-nxg1ff-0 birthday-picker__input)").click();

        }
    }