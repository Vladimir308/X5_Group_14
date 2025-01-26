package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class VkPage {

    private final SelenideElement pageName = $(".page_name");

    @Step("Переход на страницу VK")
    public VkPage goingToThePageVK() {
        switchTo().window(1);
        pageName.shouldHave(Condition.text("X5 Group"));
        return this;
    }
}