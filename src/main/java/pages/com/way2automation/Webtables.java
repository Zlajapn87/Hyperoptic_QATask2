package pages.com.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Webtables extends BaseClass{

    //This class contains all methods and webelements related to the webtables page

    @FindBy (xpath = "//button[contains(text(), \"Add User\")]")  WebElement button_AddUser;
    @FindBy (xpath="//span[contains(text(), \"E-mail\")]") WebElement caption_Email;

    public Webtables(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Protractor practice website - WebTables";
        this.PAGE_URL = "http://www.way2automation.com/angularjs-protractor/webtables/";
    }

    public void clickAddUser(){
        clickElement(button_AddUser);
    }
    public void setDescEmail(){
        clickElement(caption_Email);
    }

    public boolean searchEmail(WebDriver driver, String email) {

        //Counter that will be used for defining row number
        int i = 0;

        //Creating a list of Emails, displayed on the Webtable page
        List<WebElement> emailValues = driver.findElements(By.xpath("//tr[@class=\"smart-table-data-row ng-scope\"]/td[position()=7]"));

        //looping through the emails and verifying there is a specific email, displayed within the table
        for (WebElement emailValue : emailValues) {
            ++i;
            if(emailValue.getText().equals(email)){

                System.out.println("The required email has been found: [" + emailValue.getText() + "], Row#: [" + i + "] and Test Case is Passed");
                return true;
            }
        }
        System.out.println("The email has not been found, Test Case is Failed");
        return false;

    }

}
