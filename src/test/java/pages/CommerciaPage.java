package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CommerciaPage {
    @Step("Переход на страницу Dialog")
    public CommerciaPage checkCommercia() {
        $(".button__text");
        $(byText("Принять")).click();
        $(".css-1n9v7xy");
        $(byText("Выберите роль")).click();
        $("#react-select-2-option-0");
        $(byText("Я поставщик")).click();
        $(".css-1n9v7xy").click();
        //$(byText("Раздел")).scrollTo().click();
        $("#react-select-3-option-1").click();
        //$(byText("Отправить коммерческое предложение")).scrollTo().click();
        $(".button__text");
        $(byText("Далее")).click();
        switchTo().window("Отправить коммерческое предложение - X5 Group");
        assertThat("Отправить коммерческое предложение - X5 Group");
        open("https://www.x5.ru/ru/suppliers/submitting-commercial-offer/");
        $(".content-header").shouldHave(Condition.text("Dialog.X5"));
        return this;
    }
}