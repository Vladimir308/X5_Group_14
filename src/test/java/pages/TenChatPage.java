package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TenChatPage {
    @Step("Переход на страницу TenChat")
    public TenChatPage checkTen() {
        $("#menu-item-46848").click();
        open("https://tenchat.ru/x5group");
        $(".truncate").shouldHave(Condition.text("Group"));
        return this;
    }
}