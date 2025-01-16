package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PokupatelPage {
    @Step("Переход на страницу Dialog")
    public PokupatelPage checkPokupka() {
        $(".button__text");
        $(byText("Принять")).click();
        $(".css-1n9v7xy");
        $(byText("Выберите роль")).click();
        $("#react-select-2-option-1");
        $(byText("Я покупатель")).click();
        $(".css-szawa0");
        $(byText("Торговая сеть")).click();
        $("#react-select-4-option-0");
        $(byText("Пятерочка")).click();
        $("#input-text-10").setValue("Иванов Иван Иванович");
        $("#input-email-11").setValue("Ivanov_Test@mail.ru");
        $("#input-tel-12").setValue("9996663322");
        $("#input-text-13").setValue("Москва");
        $("#textarea-14").setValue("Люблю X5 Group");
        $("#button-15").click();
        $(".wp-block-heading").shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }
}