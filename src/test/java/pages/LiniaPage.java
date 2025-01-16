package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LiniaPage {
    @Step("Переход на страницу Dialog")
    public LiniaPage checkLinia() {
        $(".button__text");
        $(byText("Принять")).click();
        $(".css-1n9v7xy");
        $(byText("Выберите роль")).click();
        $("#react-select-2-option-8");
        $(byText("Прочие обращения")).click();
        $("#input-text-48").setValue("Иванов Иван Иванович");
        $("#input-email-49").setValue("Ivanov_Test@mail.ru");
        $("#input-tel-50").setValue("9996663322");
        $("#input-text-51").setValue("Москва");
        $("#textarea-52").setValue("Люблю X5 Group");
        $("#button-53").click();
        $(".wp-block-heading").shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }
}