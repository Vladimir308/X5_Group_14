package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TenChatPage {

    private final SelenideElement TenChat = $(".truncate");

    @Step("Переход на страницу TenChat")
    public TenChatPage goingTenChat() {
        TenChat.shouldHave(Condition.text("Group"));
        return this;
    }
}