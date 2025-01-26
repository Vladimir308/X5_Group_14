package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    TestData data = new TestData();

    private final SelenideElement resultsSearch = $(".search-results__term-hint");

    @Step("результат X5 Import")
    public SearchResultPage resultImport() {
        resultsSearch.shouldHave(text(data.port));
        return this;
    }
}
