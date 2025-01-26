package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Footer {
    SelenideElement footerElement = $(".footer .block");

    @Step("Проверка нижнего значения")
    public Footer checkFooterValue(String value) {
        footerElement.shouldHave(Condition.text(value));
        return this;
    }
}