package pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    Footer footer = new Footer();

    public MainPage openMainPage() {
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
