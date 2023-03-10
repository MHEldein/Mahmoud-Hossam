package Tests;

import Base.BaseTest;
import PagesLibrary.ImagesResultsPages;
import PagesLibrary.ResultsPage;
import org.testng.annotations.Test;

public class ImagesResultsPagesTests extends BaseTest {

    private ResultsPage resultsPage;
   private ImagesResultsPages imagesResultsPages;

   @Test
    public void checkFirstResultExist(){
       resultsPage = searchPage.search("anything");
       imagesResultsPages = resultsPage.navigateToImages();
       imagesResultsPages.checkFirstResultExits();
   }



}
