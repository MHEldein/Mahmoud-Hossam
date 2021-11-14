package Tests;

import Base.BaseTest;
import PagesLibrary.ResultsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResultsPageTests extends BaseTest {
    private ResultsPage resultsPage;

    @Test(priority = 1)
    public void verifyUserNavigationToImages() throws InterruptedException {
        resultsPage = searchPage.search("facebook");
        resultsPage.navigateToImages();
        assertTrue(resultsPage.checkImagesTab());
    }

    @Test(priority = 2)
    public void verifyClearSearchInResultPage() throws InterruptedException {
        resultsPage = searchPage.search("facebook");
        resultsPage.clearSearch();
        assertTrue(resultsPage.getWordInResultBox().isEmpty());
    }

    @Test(priority = 3)
    public void verifyResearchInResultPage() throws InterruptedException {
        resultsPage = searchPage.search("f");
        resultsPage.clearSearch();
        resultsPage.resultPageSearch("facebook");
        assertEquals(resultsPage.getWordInResultBox(), "facebook");
    }

    @Test(priority = 4)
    public void verifyNavToMaps() throws InterruptedException {
        resultsPage = searchPage.search("giza");
        resultsPage.navToMaps();
        String tex = resultsPage.getUrl();
        assertTrue(resultsPage.getUrl().contains("maps"));
    }

}
