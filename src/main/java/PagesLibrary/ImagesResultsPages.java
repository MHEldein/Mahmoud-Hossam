package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImagesResultsPages {
    WebDriver driver;
    private final By firstResult = By.id("yDmH0d");
    public ImagesResultsPages(WebDriver driver){
        this.driver = driver;
    }
public Boolean checkFirstResultExits(){
        return driver.findElement(firstResult).isDisplayed();


}

}
