package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FeedBackPage {

    TestData data = new TestData();

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
            retailChain = $(byText("Торговая сеть")),
            customer = $(byText("Я покупатель")),
            shop = $(byText("Пятерочка")),
            requestOther = $("#react-select-2-option-8"),
            choose = $(byText("Выберите роль")),
            provider = $(byText("Я поставщик")),
            chapter = $(byText("Раздел")),
            hotLine = $(byText("Горячая линия")),
            further = $(byText("Далее")),
            header = $(".content-header"),
            employee = $(byText("Я сотрудник")),
            furtherButton = $("#x5-form-22 > div.x5-form__submit > a"),
            popUpWindow = $(".hlf-heder-text"),
            complaintDirector = $("#react-select-2-option-6");

    @Step("Переход на страницу Dialog")
    public FeedBackPage staff() {
        employee.click();
        furtherButton.click();
        switchTo().window(1);
        popUpWindow.shouldHave(Condition.text(data.contacting));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage dialog() {
        provider.click();
        chapter.click();
        hotLine.click();
        further.click();
        switchTo().window(1);
        open("https://dialog-sso.x5.ru/auth/realms/dialog/protocol/openid-connect/");
        header.shouldHave(Condition.text(data.dialog));
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage buyer() {
        customer.click();
        retailChain.click();
        shop.click();
        userNameBuyer.setValue(data.user);
        emailBuyer.setValue(data.email);
        telBuyer.setValue(data.numberPhone);
        choosingCityBuyer.setValue(data.city);
        messageBuyer.setValue(data.message);
        buttonBuyer.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText(data.successfullyMessage));
        return this;
    }

    @Step("Проверить ")
    public FeedBackPage otherRequests() {
        requestOther.click();
        userNameOther.setValue(data.user);
        emailRequests.setValue(data.email);
        telOther.setValue(data.numberPhone);
        choosingCityOther.setValue(data.city);
        messageOther.setValue(data.message);
        buttonOther.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText(data.successfullyMessage));
        return this;
    }

    @Step("Выбрать роль")
    public FeedBackPage roleChoose() {
        choose.click();
        return this;
    }

    @Step("Переход на страницу Dialog")
    public FeedBackPage directorOfSecurity() {
        complaintDirector.click();
        userNameDirector.setValue(data.user);
        emailDirector.setValue(data.email);
        telDirector.setValue(data.numberPhone);
        choosingCityDirector.setValue(data.city);
        messageDirector.setValue(data.city);
        buttonDirector.click();
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText(data.successfullyMessage));
        return this;
    }
}