package Tests;

import Base.BaseTest;
import PagesLibrary.ResultsPage;
import PagesLibrary.SearchPage;
import net.bytebuddy.build.ToStringPlugin;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ResultsPageTests extends BaseTest {
    private ResultsPage resultsPage;

    @Test(priority = 1)
    public void verifyUserNavigationToImages() {
        resultsPage = searchPage.search("facebook");
        resultsPage.navigateToImages();
        assertTrue(resultsPage.checkImagesTab());
    }

    @Test(priority = 3)
    public void verifyClearSearchInResultPage(){
        resultsPage = searchPage.search("facebook");
        resultsPage.clearSearch();
        assertTrue(resultsPage.getWordInResultBox().isEmpty());
    }

    @Test(priority = 2)
    public void verifyResearchInResultPage(){
        resultsPage = searchPage.search("f");
        resultsPage.clearSearch();
        resultsPage.resultPageSearch("facebook");
        assertEquals(resultsPage.getWordInResultBox(), "facebook");
    }

}
