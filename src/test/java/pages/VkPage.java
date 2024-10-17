package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class VkPage {
    public VkPage checkVK() {
        $(byText("VK")).click();
        switchTo().window("X5 Group | ВКонтакте");
        assertThat("X5 Group | ВКонтакте");
        open("https://vk.com/x5group");
        $(".page_name").shouldHave(Condition.text("X5 Group"));
        return this;
    }
}
