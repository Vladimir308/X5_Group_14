package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import testdata.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("testX5")
public class X5Tests extends TestBase {

    @EnumSource(Language.class)
    @ParameterizedTest(name = "{index}: Проверка навигации для языка {0}")
    @DisplayName("Проверка верхнего меню на разных языках")
    public void checkTheTopMenuInDifferentLanguagesTest(Language language) {
        String url = language == Language.RU ? "https://www.x5.ru/en/" : "https://www.x5.ru/ru/";
        step("Открыть главную страницу X5Group", () -> {
            open(url);
            $$(".header__lang").find(text(language.name())).click();
        });
        for (String description : language.descriptions) {
            step("Кликнуть на раздел: " + description, () -> {
                System.out.println("Текущий язык: " + language.name() + ", раздел: " + description);
                $(byText(description)).shouldBe(visible).click();
            });
            step("Проверка совпадения для: " + description, () -> {
                System.out.println("Текущий URL: " + WebDriverRunner.url());
                $("[aria-label='breadcrumbs']").shouldHave(text(description));
            });
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
        feedBackPage.roleChoose()
                .dialog();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли жалоба диретору по безопасности сообщение успешно отправляется")
    @Test
    public void checkComplaintToTheDirectorOfSecurityTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.roleChoose()
                .directorOfSecurity();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли покупателя и нажатии далее сообщение успешно отправляется")
    @Test
    public void checkWhenChoosingTheBuyerRoleInTheFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.roleChoose()
                .buyer();
    }

    @DisplayName("Проверить что в обратной связи при выборе прочие обращения и нажатии далее сообщение успешно отправляется")
    @Test
    public void checkTheOtherRequestsInTheFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.roleChoose()
                .otherRequests();
    }

    @DisplayName("Проверить что в обратной связи при выборе роли сотрудника и нажатии далее открылась страница Обращение на Горячую линию")
    @Test
    public void checkEmployeeRoleInFeedbackTest() {
        mainPage.openMainPageRu()
                .acceptCookie();
        feedBackPage.roleChoose()
                .staff();
    }
}