package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Footer {
    SelenideElement footerElement = $(".footer .block");

    public Footer checkFooterValue(String value) {
        footerElement.shouldHave(Condition.text(value));
        return this;
    }
}
