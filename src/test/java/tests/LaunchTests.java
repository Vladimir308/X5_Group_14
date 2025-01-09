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
public class LaunchTests extends TestBase {
    @ValueSource(strings = {
            "Компания",
            "Покупателю",
            "Пресс-центр",
            "Карьера"
    })
    @ParameterizedTest(name = "{index}: {0}")
    @DisplayName("Соответствие ожидаемому")
    public void checkNavigation(String value) {
        step("Проверка всех разделов", () -> {
            mainPage.openMainPage();
            step("Кликнуть", () -> {
                $(".header__nav-link");
                $(byText(value)).click();
            });
            step("Проверка совпадения", () -> {
                $("[aria-label='breadcrumbs']").shouldHave(Condition.text(value));
            });
        });
    }

    @Test
    @DisplayName("Несоответствие ожидаемому")
    public void negativeNavigationTests() {
        mainPage.openMainPage()
                .checkPartners();
    }

    @Test
    @DisplayName("Несоответствие ожидаемому")
    public void negativeNavigationTests1() {
        mainPage.openMainPage()
                .checkInvestors();
    }

    @Test
    @DisplayName("Проверка перехода на страницу импорта")
    public void checkMainPageOpen() {
        mainPage.openMainPage()
                .checkImport();
    }

    @Test
    @DisplayName("Проверка адреса")
    public void verifyAddress() {
        mainPage.openMainPage()
                .checkAddress(testData.address);
    }

    @Test
    @DisplayName("Проверка номеров телефона")
    public void verifyPhoneNumber() {
        mainPage.openMainPage()
                .checkPhone(testData.phoneNumber_1)
                .checkPhone(testData.phoneNumber_2);
    }

    @Test
    @DisplayName("Проверка перехода на страницу X5 VK")
    public void checkX5Vk() {
        mainPage.openMainPage();
        vkPage.checkVK();
    }

    @Test
    @DisplayName("Проверка перехода на страницу TenChat")
    public void checkTenChat() {
        mainPage.openMainPage();
        tenChatPage.checkTen();
    }
}