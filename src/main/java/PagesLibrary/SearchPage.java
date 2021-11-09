package PagesLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private ChromeDriver cdriver;
    private By searchTextBox = By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    private By deleteTextIcon = By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]");
    private By searchButton = By.xpath("//body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]");
    private By feelingLuckyButton = By.xpath("//body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[2]");
    private By languageButton = By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.qarstb:nth-child(4) div.vcVZ7d:nth-child(2) div:nth-child(2) > a:nth-child(1)");
    private By googleHomeIcon = By.xpath("//body/div[1]/div[2]/div[1]/img[1]");
    private By searchSuggestion = By.xpath("//li[@role='presentation']/descendant::div[@class='sbl1']/span");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean searchTextBoxExist(){
        return driver.findElement(searchTextBox).isDisplayed();
    }

    public boolean googleHomeIconExist(){
        return driver.findElement(googleHomeIcon).isDisplayed();
    }

    public void deleteText(){
        driver.findElement(deleteTextIcon).click();
    }

    public ResultsPage search(String text){
        this.inputTextToSearch(text);
        driver.findElement(searchButton).click();
        return new ResultsPage(driver);
    }

    public ResultsPage hitFeelingLucky(String text){
        driver.findElement(searchTextBox).sendKeys(text);
        driver.findElement(feelingLuckyButton).click();
        return new ResultsPage(driver);
    }

    public void changeLanguage(){
        driver.findElement(languageButton).click();
    }

    public List<String> getSuggestionValue(){

        List<WebElement> options = new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@role='listbox']//li/descendant::span"), 0));
        List<String> list=new ArrayList<String>();
        for(int i=0;i<options.size();i++) {
            list.add(options.get(i).getText());
        }
        return list;
    }

    public void inputTextToSearch(String text){
        driver.findElement(searchTextBox).sendKeys(text);
    }

    public ResultsPage chooseFromSuggestion(int elementNumber){
        List<WebElement> elements = new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@role='listbox']//li/descendant::span"), 0));
        for(int i=0;i<elements.size();i++)
            elements.get(elementNumber).click();
            return new ResultsPage(driver);
    }

    public String getSearchText(){
        return driver.findElement(searchTextBox).getAttribute("value");
    }
}
