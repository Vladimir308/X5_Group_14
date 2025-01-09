package pages;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {
    Footer footer = new Footer();

    public MainPage openMainPage() {
        step("Открыть главную страницу");
        open("https://www.x5.ru/ru");
        return this;
    }

    public MainPage checkPhone(String number) {
        footer.checkFooterValue(number);
        return this;
    }

    public MainPage checkAddress(String address) {
        footer.checkFooterValue(address);
        return this;
    }

}
