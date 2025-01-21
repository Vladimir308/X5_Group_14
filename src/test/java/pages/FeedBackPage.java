package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FeedBackPage {

    private final SelenideElement userNameDirector = $("#input-text-39"),
            emailDirector = $("#input-email-40"),
            telDirector = $("#input-tel-41"),
            choosingCityDirector = $("#input-text-42"),
            messageDirector = $("#textarea-43"),
            buttonDirector = $("#button-44"),
            messageSuccessfully = $(".x5-form__feedback--active h5"),
            userNameOther = $("#input-text-48"),
            emailRequests = $("#input-email-49"),
            telOther = $("#input-tel-50"),
            choosingCityOther = $("#input-text-51"),
            messageOther = $("#textarea-52"),
            buttonOther = $("#button-53"),
            userNameBuyer = $("#input-text-10"),
            emailBuyer = $("#input-email-11"),
            telBuyer = $("#input-tel-12"),
            choosingCityBuyer = $("#input-text-13"),
            messageBuyer = $("#textarea-14"),
            buttonBuyer = $("#button-15"),
            complaintDirector = $("#react-select-2-option-6");


    @Step("Переход на страницу Dialog")
    public FeedBackPage buyer() {
        $(byText("Я покупатель")).click();
        $(byText("Торговая сеть")).click();
        $(byText("Пятерочка")).click();
        userNameBuyer.setValue("Иванов Иван Иванович");
        emailBuyer.setValue("Ivanov_Test@mail.ru");
        telBuyer.setValue("9996663322");
        choosingCityBuyer.setValue("Москва");
        messageBuyer.setValue("Люблю X5 Group");
        buttonBuyer.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }

    @Step("Проверить ")
    public FeedBackPage otherRequests() {
        $("#react-select-2-option-8");
        $(byText("Прочие обращения")).click();
        userNameOther.setValue("Иванов Иван Иванович");
        emailRequests.setValue("Ivanov_Test@mail.ru");
        telOther.setValue("9996663322");
        choosingCityOther.setValue("Москва");
        messageOther.setValue("Люблю X5 Group");
        buttonOther.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }

    @Step("Выбрать роль")
    public FeedBackPage roleChoose() {
        $(byText("Выберите роль")).click();
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage directorOfSecurity() {
        complaintDirector.click();
        userNameDirector.setValue("Иванов Иван Иванович");
        emailDirector.setValue("Ivanov_Test@mail.ru");
        telDirector.setValue("9996663322");
        choosingCityDirector.setValue("Moscow");
        messageDirector.setValue("Moscow");
        buttonDirector.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText("Сообщение успешно отправлено!"));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage dialog() {
        $(byText("Я поставщик")).click();
        $(byText("Раздел")).click();
        $(byText("Горячая линия")).click();
        $(byText("Далее")).click();
        switchTo().window(1);
        open("https://dialog-sso.x5.ru/auth/realms/dialog/protocol/openid-connect/");
        $(".content-header").shouldHave(Condition.text("Dialog.X5"));
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