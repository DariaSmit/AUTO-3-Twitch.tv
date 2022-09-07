package cloud.autotests.tests;

import cloud.autotests.config.PageObject;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class RegTest extends TestBase {
    cloud.autotests.config.PageObject PageObject = new PageObject();


    @Test
    @Description("Twitch.tv")
    @DisplayName("valid data test registration page")
    void RegTestPositive() {
        Configuration.holdBrowserOpen = true;
        step("открыть https://https://www.twitch.tv/", () -> {
            PageObject.openPage();
        });
        step("нажать на кнопку 'Регистрация'", ()->{
            $(".ScCoreButtonPrimary-sc-1qn4ixc-1").click();
        });
        step("ввести корректное имя пользователя",()->{
            $("#signup-username").setValue("LoginLoginovich");
        });
        step("Ввести корректный пароль", ()->{
            $("#password-input").setValue("1234567890LoginLogin");
        });
        step("подтвердить корректный пароль", ()->{
            $("#password-input-confirmation").setValue("1234567890LoginLogin");
        });
        step("ввести день рождение",()->{
            $(".birthday-picker__input").click();
            $(".focus-visible", 0).val("30");
            $(".birthday-picker__input",1).click();
            $(".focus-visible", 0).val("1992");
            $(".fQeqDH > .ScInputBase-sc-1wz0osy-0").click();
            $(".fQeqDH > .ScInputBase-sc-1wz0osy-0").selectOption("Ноябрь");
        });
        step("ввести корректный номер телефона",()->{
           $("#phone-input").setValue("999 999 99 99");
        });
        step("нажать 'Зарегистрироваться'",()->{
            $(".kjYQDW").click();
        });

        step("првоерить текст",()->{
            $("#modal-root-header").shouldHave(text("Присоединяйтесь к Twitch"));
        });
    }

    @Test
    @Description("Twitch.tv")
    @DisplayName("invalid data test registration page")
    void RegTestNegative () {
        Configuration.holdBrowserOpen = true;
        step("открыть https://https://www.twitch.tv/", () -> {
            PageObject.openPage();
        });
        step("нажать на кнопку 'Регистрация'", () -> {
            $(".ScCoreButtonPrimary-sc-1qn4ixc-1").click();
        });
        step("ввести некорректное имя пользователя", () -> {
            $("#signup-username").setValue("1234%*%*%$&#*(#");
            $(".ScAnimation-sc-cbv7d7-0").shouldHave(text("Имя пользователя должно содержать только буквы и цифры."));
        });
        step("Ввести некорректный пароль", () -> {
            $("#password-input").setValue("1234");
            $(".ScAnimation-sc-cbv7d7-0", 1).shouldHave(text("Пароль должен содержать не менее 8 символов."));

        });
        step("подтвердить некорректный пароль", () -> {
            $("#password-input-confirmation").setValue("@%$&%#$)$+_+$H$");
            $(".ScAnimation-sc-cbv7d7-0", 2).shouldHave(text("Пароли не совпадают. Повторите попытку."));
        });
        step("ввести некорректный день рождение", () -> {
            $(".birthday-picker__input").click();
            $(".focus-visible", 0).val("999");
            $(".birthday-picker__input", 1).click();
            $(".focus-visible", 0).val("99");
            $(".fQeqDH > .ScInputBase-sc-1wz0osy-0").click();
            $(".fQeqDH > .ScInputBase-sc-1wz0osy-0").selectOption("Ноябрь");
            $(".ScAnimation-sc-cbv7d7-0", 3).shouldHave(text("Введите реальную дату."));
        });
        step("ввести некорректный номер телефона", () -> {
            $("#phone-input").setValue("**#%$^%^^&$$3");
        });
        step("нажать 'Зарегистрироваться'", () -> {
            $(".fBnhfe").shouldBe(disabled);
        });

    }
}