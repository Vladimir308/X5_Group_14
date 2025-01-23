package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("x5test")
public class topMenuTests extends TestBase {

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