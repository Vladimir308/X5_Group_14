package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class DzenPage {
    public DzenPage checkDzen() {
        $("#menu-item-75").click();
        switchTo().window("X5 Group | Дзен");

        assertThat("X5 Group | Дзен");
        open("https://dzen.ru/x5group");
        $("[itemprop='name']").shouldHave(Condition.text("X5 Group"));
        return this;
    }
}
