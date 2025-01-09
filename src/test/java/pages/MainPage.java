package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Footer footer = new Footer();

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("https://www.x5.ru/ru");
        return this;
    }

    @Step("Проверка номера телефона")
    public MainPage checkPhone(String number) {
        footer.checkFooterValue(number);
        return this;
    }

    @Step("Проверка адреса")
    public MainPage checkAddress(String address) {
        footer.checkFooterValue(address);
        return this;
    }

}
