package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ContactsTest")
@DisplayName("Проверка переходов на страницы в социальных сетях, адреса и номера телефонов")
public class ContactsTests extends TestBase {

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