package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import testdata.Language;

@Tag("testX5")
public class FeedbackTests extends TestBase {

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

    @DisplayName("Проверить что в обратной связи при выборе роли поставщика раздел горячая линия переходит на страницу X5Dialog")
    @Test
    public void checkWhenChoosingTheSupplierHotlineRoleTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectProvider()
                .chapter()
                .selectHotLine()
                .openDialog();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли жалоба диретору по безопасности сообщение успешно отправляется")
    @Test
    public void checkComplaintToTheDirectorOfSecurityTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectRequestDirector()
                .enterUserDirector()
                .enterEmailDirector()
                .enterTelDirector()
                .selectCityDirector()
                .enterMessageDirector()
                .checkMessageDirector();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли покупателя и нажатии далее сообщение успешно отправляется")
    @Test
    public void checkWhenChoosingTheBuyerRoleInTheFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectBuyer()
                .selectRetailBuyer()
                .enterLastNameBuyer()
                .enterEmailBuyer()
                .enterTelBuyer()
                .selectCityBuyer()
                .enterRequestBuyer()
                .checkMessageBuyer();
    }

    @DisplayName("Проверить что в обратной связи при выборе прочие обращения и нажатии далее сообщение успешно отправляется")
    @Test
    public void checkTheOtherRequestsInTheFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectRequestOther()
                .enterUserOther()
                .enterEmailOther()
                .enterTelOther()
                .selectCityOther()
                .enterMessageOther()
                .checkMessageOther();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли сотрудника и нажатии далее открылась страница Обращение на Горячую линию")
    @Test
    public void checkEmployeeRoleInFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectStaff()
                .switchingEthicsline();
    }
}