package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DialogPage {

    TestData data = new TestData();

    private final SelenideElement header = $(".content-header");

    @Step("Переход на страницу Dialog")
    public DialogPage checkThatDialogPageOpened() {
        switchTo().window(1);
        header.shouldHave(Condition.text(data.dialog));
        return this;
    }
}
