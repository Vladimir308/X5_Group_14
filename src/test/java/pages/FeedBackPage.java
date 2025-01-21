package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FeedBackPage {

    @Step("Выбрать роль")
    public FeedBackPage roleChoose() {
        $(byText("Выберите роль")).click();
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage directorOfSecurity() {
        $("#react-select-2-option-6").click();
        $("#input-text-39").setValue("Иванов Иван Иванович");
        $("#input-email-40").setValue("Ivanov_Test@mail.ru");
        $("#input-tel-41").setValue("9996663322");
        $("#input-text-42").setValue("Moscow");
        $("#textarea-43").setValue("Moscow");
        $("#button-44").click();
        $(".x5-form__feedback--active h5").shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage dialog() {
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

    @Step("Проверить ")
    public FeedBackPage otherRequests() {
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
    public FeedBackPage buyer() {
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

    @Step("Переход на страницу Dialog")
    public FeedBackPage employee() {
        $(byText("Я сотрудник")).click();
        $("#x5-form-22 > div.x5-form__submit > a").click();
        switchTo().window(1);
        $(".hlf-heder-text").shouldHave(Condition.text("Обращение на Горячую линию по этике"));
        return this;
    }
}