package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DialogPage {
    @Step("Переход на страницу Dialog")
    public DialogPage checkDialog() {
        $("#react-select-2-option-0");
        $(byText("Я поставщик")).click();
        $(".css-1n9v7xy");
        $(byText("Раздел")).click();
        $("#react-select-3-option-0");
        $(byText("Горячая линия")).click();
        $(".button__text");
        $(byText("Далее")).click();
        switchTo().window("X5 Retail Group Авторизация");
        assertThat("X5 Retail Group Авторизация");
        open("https://dialog-sso.x5.ru/auth/realms/dialog/protocol/openid-connect/");
        $(".content-header").shouldHave(Condition.text("Dialog.X5"));
        return this;
    }
}