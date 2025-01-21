package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("x5test")
public class TopMenuTests extends TestBase {
    @ValueSource(strings = {
            "Компания",
            "Покупателю",
            "Пресс-центр",
            "Карьера"
    })
    @ParameterizedTest(name = "{index}: {0}")
    @DisplayName("Проверка разделов верхнего меню")
    public void checkTheTopMenuTest(String value) {
        step("Открыть главную страницу X5Group", () -> {
            mainPage.openMainPageRu()
                    .acceptCookie();
            step("Кликнуть", () -> {
                $(".header__nav-link");
                $(byText(value)).click();
            });
            step("Проверка открытия раздела", () -> {
                $("[aria-label='breadcrumbs']").shouldHave(Condition.text(value));
            });
        });
    }

    @Test
    @DisplayName("Несоответствие заголовка страницы")
    public void negativeNavigationTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .checkPartners();
    }

    @Test
    @DisplayName("Несоответствие заголовка страницы")
    public void negativesNavigationTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .checkInvestors();
    }

    @Test
    @DisplayName("Проверка перехода на страницу импорта")
    public void checkMainPageOpenTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .checkImport();
    }

    @Test
    @DisplayName("Проверка адреса")
    public void verifyAddressTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .checkAddress(testData.address);
    }

    @Test
    @DisplayName("Проверка номеров телефона")
    public void verifyPhoneNumberTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .checkPhone(testData.phoneNumber_1)
                .checkPhone(testData.phoneNumber_2);
    }

    @Test
    @DisplayName("Проверка перехода на страницу X5 VK")
    public void checkX5VkTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        vkPage.checkVK();
    }

    @Test
    @DisplayName("Проверка перехода на страницу TenChat")
    public void checkTenChatTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        tenChatPage.checkTen();
    }
}