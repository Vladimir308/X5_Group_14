package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private final SelenideElement resultsSearch = $(".search-results__term-hint");

    @Step("результат X5 Import")
    public SearchResultPage checkThatResultHaveQuerry(String query) {
        resultsSearch.shouldHave(text(query));
        return this;
    }
}