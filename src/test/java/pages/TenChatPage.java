package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TenChatPage {

    private final SelenideElement TenChat = $(".truncate");

    @Step("Переход на страницу TenChat")
    public TenChatPage goingTenChat() {
        TenChat.shouldBe(visible, Duration.ofSeconds(5)).shouldHave(Condition.text("Group"));
        return this;
    }
}