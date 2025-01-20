package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FeedBackPage {
//    @Step("Переход на страницу Dialog")
//    public FeedBackPage checkCommercia() {
//        $(byText("Я поставщик")).click();
//        $(byText("Раздел")).click();
//        $("#react-select-3-option-1").click();
//        $x(byText("Далее")).click();
//        $(".x5-form__conditional > div.x5-form__submit > a").click();
//        //$(byText("Далее")).click();
//        switchTo().window("Отправить коммерческое предложение - X5 Group");
//        assertThat("Отправить коммерческое предложение - X5 Group");
//        open("https://www.x5.ru/ru/suppliers/submitting-commercial-offer/");
//        $(".content-header").shouldHave(Condition.text("Dialog.X5"));
//        return this;
//    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage checkDialog() {
        $(byText("Я поставщик")).click();
        $(byText("Раздел")).click();
        $(byText("Горячая линия")).click();
        $(byText("Далее")).click();
        switchTo().window("X5 Retail Group Авторизация");
        assertThat("X5 Retail Group Авторизация");
        open("https://dialog-sso.x5.ru/auth/realms/dialog/protocol/openid-connect/");
        $(".content-header").shouldHave(Condition.text("Dialog.X5"));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage checkLinia() {
        $("#react-select-2-option-8");
        $(byText("Прочие обращения")).click();
        $("#input-text-48").setValue("Иванов Иван Иванович");
        $("#input-email-49").setValue("Ivanov_Test@mail.ru");
        $("#input-tel-50").setValue("9996663322");
        $("#input-text-51").setValue("Москва");
        $("#textarea-52").setValue("Люблю X5 Group");
        $("#button-53").click();
        $(".x5-form__feedback--active h5").shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage checkPokupka() {
        $(byText("Я покупатель")).click();
        $(byText("Торговая сеть")).click();
        $(byText("Пятерочка")).click();
        $("#input-text-10").setValue("Иванов Иван Иванович");
        $("#input-email-11").setValue("Ivanov_Test@mail.ru");
        $("#input-tel-12").setValue("9996663322");
        $("#input-text-13").setValue("Москва");
        $("#textarea-14").setValue("Люблю X5 Group");
        $("#button-15").click();
        $(".x5-form__feedback--active h5").shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }
}
