package Tests;

import Base.BaseTest;
import PagesLibrary.ResultsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPageTests extends BaseTest {
    private ResultsPage resultsPage;

    @Test(priority = 1)
    public void verifySearchTextBoxExist() {
        assertTrue(searchPage.searchTextBoxExist());
    }

    @Test(priority = 2)
    public void verifySuccessfullSearch() throws InterruptedException {
        resultsPage = searchPage.search("anything");
        assertTrue(resultsPage.resultTextBoxExist(), "Result Text Box Not Exist");

    }

    @Test(priority = 3)
    public void verifySearchResponse() throws InterruptedException {
        resultsPage = searchPage.search("selenium");
        assertEquals(resultsPage.getWordInResultBox(), "selenium");

    }

    @Test(priority = 4)
    public void verifyNoNavigationIfEmptyText() throws InterruptedException {
        resultsPage = searchPage.search("");
        assertTrue(searchPage.googleHomeIconExist(), " Google Home Icon not Exist");

    }

    @Test(priority = 5)
    public void verifyWordsWithNumAndSpecialChars() throws InterruptedException {
        resultsPage = searchPage.search("@Instabug1");
        assertEquals(resultsPage.getWordInResultBox(), "@Instabug1");
    }

    @Test(priority = 9)
    public void verifySuggestions() throws InterruptedException {
        searchPage.inputTextToSearch("face");
        assertTrue(searchPage.getSuggestionValue().contains("facebook lite"), "true");
    }

    @Test(priority = 10)
    public void verifyChoosingFromSuggestions() throws InterruptedException {
        searchPage.inputTextToSearch("face");
        resultsPage = searchPage.chooseFromSuggestion(2);
        assertEquals(resultsPage.getWordInResultBox(), "facebook lite");
    }

    @Test(priority = 6)
    public void verifyFeelingLucky() throws InterruptedException {
        resultsPage = searchPage.hitFeelingLucky("face");
        assertTrue(resultsPage.getUrl().contains("face"), "Feeling Lucky Function Failed");
    }

    @Test(priority = 7)
    public void verifyDeleteSearchText() throws InterruptedException {
        searchPage.inputTextToSearch("Instabug");
        searchPage.deleteText();
        assertTrue(searchPage.getSearchText().isEmpty());
    }

    @Test(priority = 8)
    public void verifyChangeLanguage() throws  InterruptedException   {
        String currentLang = searchPage.getLanguageText();
        searchPage.changeLanguage();
        String langAfterChange = searchPage.getLanguageText();
        assertTrue(currentLang != langAfterChange);
    }
}
