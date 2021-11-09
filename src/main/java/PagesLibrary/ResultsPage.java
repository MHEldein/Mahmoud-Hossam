package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResultsPage {
    private WebDriver driver;
    private By imagesIcon = By.xpath("//body[1]/c-wiz[1]/div[1]/header[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[1]");
    private By images = By.linkText("صور");
    private By resultTextBox = By.xpath("/html[1]/body[1]/div[4]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    private By clear = By.xpath("//body/div[@id='searchform']/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]");
    private By searchIcon = By.xpath("//body/div[@id='searchform']/div[2]/form[1]/div[1]/div[1]/div[2]/button[1]");
    private By moreMenu = By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='top_nav']/div[@id='hdtb']/div[@id='pTwnEc']/div[@id='hdtb-msb']/div[1]/span[1]/g-popup[1]/div[1]/div[1]");
    private By maps = By.cssSelector("body.srp:nth-child(2) div.main:nth-child(13) div.e9EfHf div.gTMtLb.fp-nh:nth-child(7) div.EwsJzb.sAKBe.B8Kd8d g-menu.cF4V5c.zriOQb.UU8UAb.gLSAk.rShyOb g-menu-item.ErsxPb:nth-child(1) div.znKVS.OSrXXb.tnhqA a:nth-child(1) span.bmaJhd.iJddsb > svg:nth-child(1)");
    private By result = By.xpath("//h3[contains(text(),'Instabug: Ship your app confidently with the best ')]");

    public ResultsPage(WebDriver driver){
        this.driver =  driver;
    }

    public void navigateToImages(){
        driver.findElement(images).click();
    }

    public boolean checkImagesTab(){
       return driver.findElement(imagesIcon).isDisplayed();
    }

    public boolean resultTextBoxExist(){
       return driver.findElement(resultTextBox).isDisplayed();
    }

    public String getWordInResultBox(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultTextBox));
        return driver.findElement(resultTextBox).getAttribute("value");
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void clearSearch(){
        driver.findElement(clear).click();
    }

    public ResultsPage resultPageSearch(String text){
        driver.findElement(resultTextBox).sendKeys(text);
        this.pressSearchIcon();
        return new ResultsPage(driver);
    }

    public void pressSearchIcon(){
        driver.findElement(searchIcon).click();
    }
}
