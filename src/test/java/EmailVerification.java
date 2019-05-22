import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class EmailVerification {

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/Drivers/chromedriver_74.exe");
        driver = new ChromeDriver();
    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void emailVerification() {
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
        WebElement button_AddUser = driver.findElement(By.xpath("//button[contains(text(), \"Add User\")]"));
        button_AddUser.click();

        WebElement field_FirstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
        WebElement field_LastName = driver.findElement(By.xpath("//input[@name='LastName']"));
        WebElement field_UserName = driver.findElement(By.xpath("//input[@name='UserName']"));
        WebElement field_password = driver.findElement(By.xpath("//input[@name='Password']"));
        WebElement radio_Company = driver.findElement(By.xpath("(//label[@class=\"radio ng-scope ng-binding\"])[1]"));
        WebElement select_role = driver.findElement(By.xpath("//select[@name = 'RoleId']"));
        WebElement field_Email = driver.findElement(By.xpath("//input[@name = 'Email']"));
        WebElement field_CellPhone = driver.findElement(By.xpath("//input[@name = 'Mobilephone']"));
        WebElement button_Save = driver.findElement(By.xpath("//button[contains(text(), \"Save\")]"));
        WebElement caption_Email = driver.findElement(By.xpath("//span[contains(text(), \"E-mail\")]"));

        field_FirstName.sendKeys("test");
        field_LastName.sendKeys("test");
        field_UserName.sendKeys("test123");
        field_password.sendKeys("test123");
        radio_Company.click();

        Select select = new Select(select_role);
        select.selectByVisibleText("Customer");

        field_Email.sendKeys("test@testtest1.com");
        field_CellPhone.sendKeys("1234123412");
        button_Save.click();
        caption_Email.click();

        Assert.assertTrue(searchEmail(driver, "test@testtest11.com"));


    }

    public boolean searchEmail(WebDriver driver, String email) {

        List<WebElement> emailValues = driver.findElements(By.xpath("//tr[@class=\"smart-table-data-row ng-scope\"]/td[position()=7]"));
        for (WebElement emailValue : emailValues) {


            if(emailValue.getText().equals(email)){
                System.out.println("The email has been found, Test Case is Passed");
                return true;
            }
        }
        System.out.println("The email has not been found, Test Case is Passed");
        return false;

        }

    };





