package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import testdata.Language;

@Tag("TopMenuTest")
@DisplayName("Проверка открытия верхнего меню")
public class TopMenuTests extends TestBase {

    @EnumSource(Language.class)
    @ParameterizedTest(name = "{index}: Проверка навигации для языка {0}")
    @DisplayName("Проверка верхнего меню на разных языках")
    public void checkTheTopMenuInDifferentLanguagesTest(Language language) {
        String url = language == Language.RU ? "https://www.x5.ru/en/" : "https://www.x5.ru/ru/";
        mainPage.openPage(url)
                .selectLanguage(language.name());
        for (String description : language.descriptions) {
            mainPage.clickOnSection(description)
                    .checkBreadcrumbs(description);
        }
    }

    @ValueSource(strings = {
            "Компания",
            "Покупателю",
            "Пресс-центр",
            "Карьера"
    })
    @ParameterizedTest(name = "{index}: {0}")
    @DisplayName("Проверка разделов верхнего меню")
    public void checkTheTopMenuTest(String menuItem) {
        mainPage.openMainPageRu()
                .acceptCookie()
                .clickOnMenuItem(menuItem)
                .verifyBreadcrumbs(menuItem);
    }

    @DisplayName("Проверить что при нажатии на Investors отображается Investor Relations")
    @Test
    public void checkTheTopMenuInvestorTest() {
        mainPage.openMainPageEn()
                .checkInvestor();
    }

    @DisplayName("Проверить что при нажатии на Press Centre отображается Press center")
    @Test
    public void checkTheTopMenuPressCenterTest() {
        mainPage.openMainPageEn()
                .checkPressCentre();
    }

    @Test
    @DisplayName("Проверка поиска")
    public void checkSearchTest() {
        String query = "X5 Import";
        mainPage.openMainPageRu()
                .acceptCookie()
                .setSearchField(query);
        searchResultPage.checkThatResultHaveQuerry(query);
    }
}