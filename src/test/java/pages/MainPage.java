package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    Footer footer = new Footer();
    TestData data = new TestData();
    private final ElementsCollection lang = $$(".header__lang");
    private final SelenideElement
            searchButton = $(".header-search__search-btn"),
            inputSearch = $("#search-term-header"),
            result = $("[aria-label='breadcrumbs']"),
            accept = $(byText("Принять")),
            partner = $(byText("Партнёрам")),
            investor = $(byText("Акционерам и инвесторам")),
            investors = $(byText("Investors")),
            pressCenter = $(byText("Press Centre")),
            vk = $(byText("VK")),
            tenChat = $("#menu-item-46848");

    @Step("Кликнуть на элемент верхнего меню")
    public MainPage clickOnMenuItem(String menuItem) {
        $(byText(menuItem)).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Виден элемент верхнего меню")
    public MainPage verifyBreadcrumbs(String expectedText) {
        result.shouldHave(Condition.text(expectedText));
        return this;
    }

    @Step("Открыть главную страницу")
    public MainPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Открыть главную страницу")
    public MainPage selectLanguage(String language) {
        lang.find(text(language)).click();
        return this;
    }

    @Step("Кликнуть на раздел: + description")
    public MainPage clickOnSection(String description) {
        $(byText(description)).shouldBe(visible).click();
        return this;
    }

    @Step("Проверка совпадения для: + description")
    public MainPage checkBreadcrumbs(String description) {
        result.shouldHave(text(description));
        return this;
    }

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

    @Step("Вводим X5 Import")
    public MainPage enterImport() {
        searchButton.click();
        inputSearch.setValue(data.port).pressEnter();
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

    @Step("Кликнуть на VK")
    public MainPage clickVK() {
        vk.click();
        return this;
    }

    @Step("Кликнуть на TenChat")
    public MainPage clickTen() {
        tenChat.click();
        return this;
    }
}