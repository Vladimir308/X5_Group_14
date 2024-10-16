package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("x5test")
public class LaunchTests extends TestBase {

    @Test
    @DisplayName("Проверка импорта")
    public void checkMainPageOpen() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Ввести в поиск X5 Import", () -> {
            $(".header-search__search-btn").click();
            $("#search-term-header").setValue("X5 Import").pressEnter();
        });
        step("Результат X5 Import", () -> {
                $(".search-results__term-hint").shouldHave(text("X5 Import"));
        });
    }

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
            step("Открыть главную страницу", () -> {
                mainPage.openMainPage();
            });
            step("Кликнуть", () -> {
                $(byText(value)).click();;
            });
            step("Проверка совпадения", () -> {
                $("[aria-label='breadcrumbs']").shouldHave(Condition.text(value));
            });
        });
    }

    @Test
    @DisplayName("Несоответствие ожидаемому")
    public void negativeNavigationTests() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Кликаем Партнёрам", () -> {
            $(byText("Партнёрам")).click();
        });
        step("Результат Партнерам", () -> {
            $("[aria-label='breadcrumbs']");
            $(".hero-company__title").shouldHave(text("Партнерам"));
        });
    }

    @Test
    @DisplayName("Несоответствие ожидаемому")
    public void negativeNavigationTests1() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Кликаем Акционерам и инвесторам", () -> {
            $(byText("Акционерам и инвесторам")).click();
        });
        step("Результат Инвесторам", () -> {
            $("[aria-label='breadcrumbs']");
            $(".hero-for-investors__title").shouldHave(text("Инвесторам"));
        });
    }

    @Test
    @DisplayName("Проверка адреса")
    public void verifyAddress() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Адрес совпадает", () -> {
            mainPage.checkAddress(testData.address);
        });
    }

    @Test
    @DisplayName("Проверка номеров телефона")
    public void verifyPhoneNumber() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Номера совпадают", () -> {
            mainPage.checkPhone(testData.phoneNumber_1)
                    .checkPhone(testData.phoneNumber_2);
        });
    }

    @Test
    @DisplayName("Проверка перехода на страницу X5 VK")

    public void checkX5Vk() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Переходим на страницу VK", () -> {
            footer.checkVK();
        });

    }

    @Test
    @DisplayName("Проверка перехода на страницу X5 Dzen")
    public void checkX5Dzen() {
        step("Открыть главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Переходим на страницу Dzen", () -> {
            footer.checkDzen();
        });

    }
}

