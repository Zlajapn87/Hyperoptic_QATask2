package pages.com.way2automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class BaseClass {


    public String PAGE_URL;
    public String PAGE_TITLE;
    public WebDriver driver;

    //Constructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }


    /* Common methods related to any available page*/
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

    //Method that generates random (unique) email
    public String emailGenerator(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email = ("test"+ randomInt +"@gmail.com");
        return email;
    }

    public String getPageUrl(){
        return PAGE_URL;
    }
    public String getPageTitle(){
        return PAGE_TITLE;
    }
}
