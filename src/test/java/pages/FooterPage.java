package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FooterPage {
    SelenideElement footerElement = $(".footer .block");

    public FooterPage checkFooterValue(String value) {
        footerElement.shouldHave(Condition.text(value));
        return this;
    }

    public FooterPage checkVK() {
        $(byText("VK")).click();
        switchTo().window("X5 Group | ВКонтакте");
        assertThat("X5 Group | ВКонтакте");

        $(".page_name").shouldHave(Condition.text("X5 Group"));
        return this;
    }

    public FooterPage checkDzen() {
        $("#menu-item-75").click();
        switchTo().window("X5 Group | Дзен");

        assertThat("X5 Group | Дзен");
        $("[itemprop='name']").shouldHave(Condition.text("X5 Group"));
        return this;
    }
}
