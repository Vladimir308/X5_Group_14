package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class HotLinePage {

    TestData data = new TestData();

    private final SelenideElement popUpWindow = $(".hlf-heder-text");

    @Step("Переход на горячую линию по этике")
    public HotLinePage checkThatHotLInePageOpened() {
        switchTo().window(1);
        popUpWindow.shouldHave(Condition.text(data.contacting));
        return this;
    }
}
