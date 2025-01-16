package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SotrudnikPage {
    @Step("Переход на страницу Dialog")
    public SotrudnikPage checkSotrudnik() {
        $(".button__text");
        $(byText("Принять")).click();
        $(".css-1n9v7xy");
        $(byText("Выберите роль")).click();
        $("#react-select-2-option-3");
        $(byText("Я сотрудник")).click();
        $(".button__text");
        $(byText("Далее")).click();
        switchTo().window("X5Group");
        assertThat("X5Group");
        open("https://www.x5.ru/ru/Pages/HotlineForm/form.aspx");
        $(".hlf-heder-text").shouldHave(Condition.text("Обращение на Горячую линию по этике"));
        return this;
    }
}