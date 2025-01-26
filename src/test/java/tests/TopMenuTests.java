package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import testdata.Language;

@Tag("x5test")
public class TopMenuTests extends TestBase {

    @EnumSource(Language.class)
    @ParameterizedTest(name = "{index}: Проверка навигации для языка {0}")
    @DisplayName("Проверка верхнего меню на разных языках")
    public void checkTheTopMenuInDifferentLanguagesTest(Language language) {
        String url = language == Language.RU ? "https://www.x5.ru/en/" : "https://www.x5.ru/ru/";
        mainPage.openPage(url)
                .selectLanguage(language.name());
        for (String description : language.descriptions) {
            mainPage.clickOnSection(description)
                    .checkBreadcrumbs(description);
        }
    }

    @DisplayName("Проверить что при нажатии на Investors отображается Investor Relations")
    @Test
    public void checkTheTopMenuInvestorTest() {
        mainPage.openMainPageEn()
                .checkInvestor();
    }

    @DisplayName("Проверить что при нажатии на Press Centre отображается Press center")
    @Test
    public void checkTheTopMenuPressCenterTest() {
        mainPage.openMainPageEn()
                .checkPressCentre();
    }

    @ValueSource(strings = {
            "Компания",
            "Покупателю",
            "Пресс-центр",
            "Карьера"
    })
    @ParameterizedTest(name = "{index}: {0}")
    @DisplayName("Проверка разделов верхнего меню")
    public void checkTheTopMenuTest(String menuItem) {
        mainPage.openMainPageRu()
                .acceptCookie()
                .clickOnMenuItem(menuItem)
                .verifyBreadcrumbs(menuItem);
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
    @DisplayName("Проверка поиска")
    public void checkingTheImportStatusTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .enterImport();
        searchResultPage.resultImport();
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
                .acceptCookie()
                .clickVK();
        vkPage.goingToThePageVK();
    }

    @Test
    @DisplayName("Проверка перехода на страницу TenChat")
    public void checkTenChatTest() {
        mainPage.openMainPageRu()
                .acceptCookie()
                .clickTen();
        tenChatPage.goingTenChat();
    }
}