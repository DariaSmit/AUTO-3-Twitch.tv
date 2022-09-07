package cloud.autotests.tests;

import cloud.autotests.config.PageObject;
import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPage extends TestBase {
    cloud.autotests.config.PageObject PageObject = new PageObject();



    @Test
    @Description("Twitch.tv")
    @DisplayName("Twitch.tv test main page")
    void MainHeaderPageTest() {
        step("открыть https://https://www.twitch.tv/", () -> {
            PageObject.openPage();
        });
        step("нажать на иконку выпадающего меню", () -> {
            $(".ScAspectRatio-sc-1sw3lwy-1").click();
        });
        step("проверить заголовки выпадающего меню", () -> {
            PageObject.assertHeader("Блог")
                    .assertHeader("Вакансии")
                    .assertHeader("Загрузка приложений")
                    .assertHeader("Партнеры")
                    .assertHeader("Подробнее")
                    .assertHeader("Пресса")
                    .assertHeader("Разработчики")
                    .assertHeader("Разработчики")
                    .assertHeader("Рекламодатели")
                    .assertHeader("IGDB")
                    .assertHeader("Loot Cave — магазин фирменных товаров")
                    .assertHeader("Twitch Gift Card")
                    .assertHeader("Twitch Turbo")
                    .assertHeader("Справка и юридическая информация")
                    .assertHeader("Заявление о доступности")
                    .assertHeader("Использование файлов cookie")
                    .assertHeader("Подбор рекламы")
                    .assertHeader("Политика конфиденциальности")
                    .assertHeader("Правила сообщества")
                    .assertHeader("Справка")
                    .assertHeader("Центр безопасности")
                    .assertHeader("Безопасность")
                    .assertHeader("Условия");
        });
    }

    @Test
    @Description("Twitch.tv")
    @DisplayName("Twitch.tv switching theme")
    void MainPageThemeTest() {
        step("открыть https://https://www.twitch.tv/", () -> {
            PageObject.openPage();
        });
        step("нажать на ярлык профиля и проверить смену цветовой палитры",()->{
            $(".Layout-sc-nxg1ff-0:nth-child(2) > .Layout-sc-nxg1ff-0:nth-child(1) > div:nth-child(1) > .ScCoreButton-sc-1qn4ixc-0:nth-child(1) path:nth-child(1)").click();
            $(".ScToggleButton-sc-796zbf-2").click();
            WebElement customer = $(By.className(".tw-root--theme-dark"));
            $(".ScToggleButton-sc-796zbf-2").click();
            WebElement customer1 = $(By.className(".tw-root--theme-light"));
            $(".ScToggleButton-sc-796zbf-2").click();
            WebElement customer2 = $(By.className(".tw-root--theme-dark"));
         });
    }

    @Test
    @Description("Twitch.tv")
    @DisplayName("Twitch.tv switching subsections")
    void MainSubsectionsTest() {
        step("открыть https://https://www.twitch.tv/", () -> {
            PageObject.openPage();
        });
        step("открыть подраздел 'Игры'",()-> {
            $(".ScInteractableBase-sc-awmohi-0").click();
            $(".esports-directory-home-header").shouldBe(Condition.text("Игры"));
        });
        step("открыть подраздел 'IRL'",()-> {
            $(".ScInteractableBase-sc-awmohi-0",1).click();
            $(".esports-directory-home-header").shouldBe(Condition.text("IRL"));
        });
        step("открыть подраздел 'Музыка'",()-> {
            $(".ScInteractableBase-sc-awmohi-0",2).click();
            $(".esports-directory-home-header").shouldBe(Condition.text("Музыка"));
        });
        step("открыть подраздел 'Киберспорт'",()-> {
            $(".ScInteractableBase-sc-awmohi-0",3).click();
            $(".esports-directory-home-header").shouldBe(Condition.text("Киберспорт"));
        });
        step("открыть подраздел 'Творчество'",()-> {
            $(".ScInteractableBase-sc-awmohi-0",4).click();
            $(".esports-directory-home-header").shouldBe(Condition.text("Творчество"));
        });

    }
}
