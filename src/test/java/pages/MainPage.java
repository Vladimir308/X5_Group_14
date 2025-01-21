package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Footer footer = new Footer();
    private final SelenideElement titleCompany = $(".hero-company__title");
    private final SelenideElement titleInvestor = $(".hero-for-investors__title");
    private final SelenideElement searchButton = $(".header-search__search-btn");
    private final SelenideElement inputSearch = $("#search-term-header");
    private final SelenideElement resultsSearch = $(".search-results__term-hint");

    @Step("Принять соглашение Cookie")
    public MainPage acceptCookie() {
        $(byText("Принять")).click();
        return this;
    }

    @Step("Открыть главную страницу на русском языке")
    public MainPage openMainPageRu() {
        open("/ru/");
        return this;
    }

    @Step("Открыть главную страницу на английском языке")
    public MainPage openMainPageEn() {
        open("/en/");
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
        titleCompany.shouldHave(text("Партнерам"));
        return this;
    }

    @Step("Проверка раздела Import")
    public MainPage checkImport() {
        searchButton.click();
        inputSearch.setValue("X5 Import").pressEnter();
        resultsSearch.shouldHave(text("X5 Import"));
        return this;
    }

    @Step("Проверка раздела Investors")
    public MainPage checkInvestors() {
        $(byText("Акционерам и инвесторам")).click();
        $("[aria-label='breadcrumbs']");
        titleInvestor.shouldHave(text("Инвесторам"));
        return this;
    }

    @Step("Проверка раздела Investors")
    public MainPage checkInvestor() {
        $(byText("Investors")).click();
        $("[aria-label='breadcrumbs']");
        titleInvestor.shouldHave(text("Investor Relations"));
        return this;
    }

    @Step("Проверка раздела Press Centre")
    public MainPage checkPressCentre() {
        $(byText("Press Centre")).click();
        $("[aria-label='breadcrumbs']");
        titleCompany.shouldHave(text("Press Center"));
        return this;
    }
}