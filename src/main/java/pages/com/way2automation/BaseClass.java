package pages.com.way2automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class BaseClass {

    public String PAGE_URL;
    public String PAGE_TITLE;
    public WebDriver driver;

    //constructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage(){
        driver.get(getPageUrl());
        Assert.assertTrue((driver.getTitle()).contains(getPageTitle()));
    }

    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void clickElement(WebElement element) {
        element.click();
    }
     public void selectValueInDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
        };

    public String getPageUrl(){
        return PAGE_URL;
    }
    public String getPageTitle(){
        return PAGE_TITLE;
    }
}
