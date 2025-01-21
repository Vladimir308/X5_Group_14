package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    Footer footer = new Footer();
    TestData data = new TestData();
    private final SelenideElement
            searchButton = $(".header-search__search-btn"),
            inputSearch = $("#search-term-header"),
            result = $("[aria-label='breadcrumbs']"),
            accept = $(byText("Принять")),
            partner = $(byText("Партнёрам")),
            investor = $(byText("Акционерам и инвесторам")),
            investors = $(byText("Investors")),
            pressCenter = $(byText("Press Centre")),
            resultsSearch = $(".search-results__term-hint");

    @Step("Принять соглашение Cookie")
    public MainPage acceptCookie() {
        accept.click();
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
        partner.click();
        result.shouldHave(text(data.partner));
        return this;
    }

    @Step("Проверка раздела Import")
    public MainPage checkImport() {
        searchButton.click();
        inputSearch.setValue(data.port).pressEnter();
        resultsSearch.shouldHave(text(data.port));
        return this;
    }

    @Step("Проверка раздела Investors")
    public MainPage checkInvestors() {
        investor.click();
        result.shouldHave(text(data.invest));
        return this;
    }

    @Step("Проверка раздела Investors")
    public MainPage checkInvestor() {
        investors.click();
        result.shouldHave(text(data.relations));
        return this;
    }

    @Step("Проверка раздела Press Centre")
    public MainPage checkPressCentre() {
        pressCenter.click();
        result.shouldHave(text(data.center));
        return this;
    }
}