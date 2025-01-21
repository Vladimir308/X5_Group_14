package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Footer footer = new Footer();
//    private final SelenideElement
//            searchCard = $(accessibilityId("Search Wikipedia")),
//            topMenu = $(id(".header__nav-link"));
//
//
//    @Step("Проверка регистрации, видимость Login")
//    public void loginButton() {
//        menuButton.click();
//        nameAccount.shouldHave(text("Log in to Wikipedia"));
//        nameAccount.click();
//    }

    @Step("Принять соглашение Cookie")
    public MainPage acceptCookie() {
        $(byText("Принять")).click();
        return this;
    }

    @Step("Открыть главную страницу на русском языке")
    public MainPage openMainPageRu() {
        open("https://www.x5.ru/ru/");
        return this;
    }

    @Step("Открыть главную страницу на английском языке")
    public MainPage openMainPageEn() {
        open("https://www.x5.ru/en/");
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

    @Step("Проверка раздела Investors")
    public MainPage checkInvestors() {
        $(byText("Акционерам и инвесторам")).click();
        $("[aria-label='breadcrumbs']");
        $(".hero-for-investors__title").shouldHave(text("Инвесторам"));
        return this;
    }

    @Step("Проверка раздела Investors")
    public MainPage checkInvestor() {
        $(byText("Investors")).click();
        $("[aria-label='breadcrumbs']");
        $(".hero-for-investors__title").shouldHave(text("Investor Relations"));
        return this;
    }

    @Step("Проверка раздела Press Centre")
    public MainPage checkPressCentre() {
        $(byText("Press Centre")).click();
        $("[aria-label='breadcrumbs']");
        $(".hero-company__title").shouldHave(text("Press Center"));
        return this;
    }
}