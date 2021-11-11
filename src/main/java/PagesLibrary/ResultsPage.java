package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
    private final WebDriver driver;
    private final By imagesIcon = By.xpath("//body[1]/c-wiz[1]/div[1]/header[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[1]");
    private final By images = By.linkText("صور");
    private final By resultTextBox = By.cssSelector("body.srp:nth-child(2) div.CvDJxb:nth-child(9) div.Q3DXx.yIbDgf form.tsf div.A8SBwf:nth-child(1) div.RNNXgb div.SDkEP div.a4bIc > input.gLFyf.gsfi:nth-child(3)");
    private final By clear = By.xpath("//body/div[@id='searchform']/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]");
    private final By searchIcon = By.xpath("//body/div[@id='searchform']/div[2]/form[1]/div[1]/div[1]/div[2]/button[1]");
    private final By moreMenu = By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='top_nav']/div[@id='hdtb']/div[@id='pTwnEc']/div[@id='hdtb-msb']/div[1]/span[1]/g-popup[1]/div[1]/div[1]");
    private final By maps = By.cssSelector("body.srp:nth-child(2) div.main:nth-child(13) div.e9EfHf div.gke0pe:nth-child(5) div.GLcBOb div.yg51vc div.IC1Ck div:nth-child(1) div.MUFPAc div.hdtb-mitem:nth-child(2) a:nth-child(1) > span:nth-child(2)");
    private final By result = By.xpath("//h3[contains(text(),'Instabug: Ship your app confidently with the best ')]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToImages() {
        driver.findElement(images).click();
    }

    public boolean checkImagesTab() {
        return driver.findElement(imagesIcon).isDisplayed();
    }

    public boolean resultTextBoxExist() {
        return driver.findElement(resultTextBox).isDisplayed();
    }

    public String getWordInResultBox() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultTextBox));
        return driver.findElement(resultTextBox).getAttribute("value");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clearSearch() {
        driver.findElement(clear).click();
    }

    public ResultsPage resultPageSearch(String text) {
        driver.findElement(resultTextBox).sendKeys(text);
        this.pressSearchIcon();
        return new ResultsPage(driver);
    }

    public void pressSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    public void navToMaps() {
        driver.findElement(maps).click();
    }
}
