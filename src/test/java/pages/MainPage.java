package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Footer footer = new Footer();

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("https://www.x5.ru/ru");
        return this;
    }

    @Step("Проверка номера телефона")
    public MainPage checkPhone(String number) {
        footer.checkFooterValue(number);
        return this;
    }

    @Step("Проверка адреса")
    public MainPage checkAddress(String address) {
        footer.checkFooterValue(address);
        return this;
    }

    @Step("Проверка адреса")
    public MainPage checkPartners() {
        $(".header__nav-link");
        $(byText("Партнёрам")).click();
        $("[aria-label='breadcrumbs']");
        $(".hero-company__title").shouldHave(text("Партнерам"));
        return this;
    }

    @Step("Проверка раздела Import")
    public MainPage checkImport() {
        $(".header-search__search-btn").click();
        $("#search-term-header").setValue("X5 Import").pressEnter();
        $(".search-results__term-hint").shouldHave(text("X5 Import"));
        return this;
    }

}
