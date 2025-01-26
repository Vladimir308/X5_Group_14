package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

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
            employee = $(byText("Я сотрудник")),
            furtherButton = $("#x5-form-22 > div.x5-form__submit > a"),
            complaintDirector = $("#react-select-2-option-6");

    @Step("Выбрать жалоба директору по безопасности")
    public FeedBackPage selectRequestDirector() {
        complaintDirector.click();
        return this;
    }

    @Step("Ввести фамилию имя отчество")
    public FeedBackPage enterUserDirector() {
        userNameDirector.setValue(data.user);
        return this;
    }

    @Step("Ввести email")
    public FeedBackPage enterEmailDirector() {
        emailDirector.setValue(data.email);
        return this;
    }

    @Step("Ввести телефон")
    public FeedBackPage enterTelDirector() {
        telDirector.setValue(data.numberPhone);
        return this;
    }

    @Step("Выбрать город")
    public FeedBackPage selectCityDirector() {
        choosingCityDirector.setValue(data.city);
        return this;
    }

    @Step("Ввести обращение")
    public FeedBackPage enterMessageDirector() {
        messageDirector.setValue(data.message);
        return this;
    }

    @Step("Кликнуть отправить")
    public FeedBackPage clickSendDirector() {
        buttonDirector.click();
        return this;
    }

    @Step("Проверить что сообщение успешно отправляется")
    public FeedBackPage сheckThatMessageSuccessfulySent() {
        messageSuccessfully.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(exactText(data.successfullyMessage));
        return this;
    }

    @Step("Выбрать прочие обращения")
    public FeedBackPage selectRequestOther() {
        requestOther.click();
        return this;
    }

    @Step("Ввести фамилию имя отчество")
    public FeedBackPage enterUserOther() {
        userNameOther.setValue(data.user);
        return this;
    }

    @Step("Ввести email")
    public FeedBackPage enterEmailOther() {
        emailRequests.setValue(data.email);
        return this;
    }

    @Step("Ввести телефон")
    public FeedBackPage enterTelOther() {
        telOther.setValue(data.numberPhone);
        return this;
    }

    @Step("Выбрать город")
    public FeedBackPage selectCityOther() {
        choosingCityOther.setValue(data.city);
        return this;
    }

    @Step("Ввести обращение")
    public FeedBackPage enterMessageOther() {
        messageOther.setValue(data.message);
        return this;
    }

    @Step("Кликнуть отправить")
    public FeedBackPage clickSendOther() {
        buttonOther.click();
        return this;
    }

    @Step("Выбрать роль")
    public FeedBackPage selectRoleChoose() {
        choose.click();
        return this;
    }

    @Step("Выбрать я сотрудник и нажать далее")
    public FeedBackPage selectStaff() {
        employee.click();
        furtherButton.click();
        return this;
    }

    @Step("Выбрать я поставщик")
    public FeedBackPage selectProvider() {
        provider.click();
        return this;
    }

    @Step("Кликнуть на раздел")
    public FeedBackPage selectChapter() {
        chapter.click();
        return this;
    }

    @Step("Выбрать горячая линия")
    public FeedBackPage selectHotLine() {
        hotLine.click();
        further.click();
        return this;
    }

    @Step("Нажать далее")
    public FeedBackPage selectClickLine() {
        further.click();
        return this;
    }

    @Step("Выбрать я покупатель")
    public FeedBackPage selectBuyer() {
        customer.click();
        return this;
    }

    @Step("Выбрать торговая сеть пятерочка")
    public FeedBackPage selectRetailBuyer() {
        retailChain.click();
        shop.click();
        return this;
    }

    @Step("Ввести фамилию имя отчество")
    public FeedBackPage enterLastNameBuyer() {
        userNameBuyer.setValue(data.user);
        return this;
    }

    @Step("Ввести email")
    public FeedBackPage enterEmailBuyer() {
        emailBuyer.setValue(data.email);
        return this;
    }

    @Step("Ввести телефон")
    public FeedBackPage enterTelBuyer() {
        telBuyer.setValue(data.numberPhone);
        return this;
    }

    @Step("Выбрать город")
    public FeedBackPage selectCityBuyer() {
        choosingCityBuyer.setValue(data.city);
        return this;
    }

    @Step("Ввести обращение")
    public FeedBackPage enterRequestBuyer() {
        messageBuyer.setValue(data.message);
        return this;
    }

    @Step("Кликнуть отправить")
    public FeedBackPage clickSendBuyer() {
        buttonBuyer.click();
        return this;
    }
}