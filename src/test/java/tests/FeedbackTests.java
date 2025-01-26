package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("FeedbackTest")
@DisplayName("Проверка функционала обратной связи")
public class FeedbackTests extends TestBase {

    @DisplayName("Проверить что в обратной связи при выборе роли поставщика раздел горячая линия переходит на страницу X5Dialog")
    @Test
    public void checkWhenChoosingTheSupplierHotlineRoleTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectProvider()
                .selectChapter()
                .selectHotLine()
                .selectClickLine();
        dialogPage.checkThatDialogPageOpened();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли жалоба директору по безопасности сообщение успешно отправляется")
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
                .clickSendDirector()
                .сheckThatMessageSuccessfulySent();
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
                .clickSendBuyer()
                .сheckThatMessageSuccessfulySent();
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
                .clickSendOther()
                .сheckThatMessageSuccessfulySent();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли сотрудника и нажатии далее открылась страница Обращение на Горячую линию")
    @Test
    public void checkEmployeeRoleInFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.selectRoleChoose()
                .selectStaff();
        hotLinePage.checkThatHotLInePageOpened();
    }
}