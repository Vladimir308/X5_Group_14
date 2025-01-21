package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VkPage {
    @Step("Переход на страницу VK")
    public VkPage checkVK() {
        $(byText("VK")).click();
        switchTo().window(1);
        open("https://vk.com/x5group");
        $(".page_name").shouldHave(Condition.text("X5 Group"));
        return this;
    }
}
