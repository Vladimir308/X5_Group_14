package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SotrudnikPage {
    public SotrudnikPage checkSotrudnik() {

        @Step("Принять соглашение Cookie")
        public SotrudnikPage() {
            $("#react-select-2-option-3");
            $(byText("Я сотрудник")).click();
            return this;
        }
        @Step("Принять соглашение Cookie")
        public SotrudnikPage() {
            $(".button__text");
            $(byText("Далее")).click();
            return this;
        }
        @Step("Принять соглашение Cookie")
        public SotrudnikPage() {
            switchTo().window("X5Group");
            assertThat("X5Group");
            open("https://www.x5.ru/ru/Pages/HotlineForm/form.aspx");
            $(".hlf-heder-text").shouldHave(Condition.text("Обращение на Горячую линию по этике"));
            return this;
        }
    }
}