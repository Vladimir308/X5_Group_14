package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class TestBase {

    MainPage mainPage = new MainPage();
    TestData testData = new TestData();
    VkPage vkPage = new VkPage();
    TenChatPage tenChatPage = new TenChatPage();
    DialogPage dialogPage = new DialogPage();
    CommerciaPage commerciaPage = new CommerciaPage();
    PokupatelPage pokupatelPage = new PokupatelPage();
    LiniaPage liniaPage = new LiniaPage();
    SotrudnikPage sotrudnikPage = new SotrudnikPage();

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider() {
        };
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }
}
