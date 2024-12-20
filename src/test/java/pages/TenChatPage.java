package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TenChatPage {
    public TenChatPage checkTen() {
        $("#menu-item-46848").click();
        open("https://tenchat.ru/x5group");
        $(".truncate").shouldHave(Condition.text("Group"));
        return this;
    }
}