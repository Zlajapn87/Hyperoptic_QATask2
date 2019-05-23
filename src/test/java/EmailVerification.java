import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.com.way2automation.AddUser;
import pages.com.way2automation.Webtables;

public class EmailVerification {

    public WebDriver driver;
    Webtables  wTable;
    AddUser aUser;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/Drivers/chromedriver_74.exe");
        driver = new ChromeDriver();

        //Page factory
        wTable = PageFactory.initElements(driver, Webtables.class);
        aUser = PageFactory.initElements(driver, AddUser.class);
    }

   /* @AfterClass
    public void tearDown(){
        driver.quit();
    }*/

    @Test
    public void emailVerification() {

        //Filling out the Add User - form, and filtering the emails in desc order
        wTable.loadPage();
        wTable.clickAddUser();
        aUser.setTtext_FirstName("TestFirstName");
        aUser.setTtext_LastName("TestLastName");
        aUser.setTtext_UserName("TestUserName");
        aUser.setTtext_Password("TestPassword");
        aUser.selectCompany();
        aUser.selectRole("Customer");
        String textEmail = aUser.setTtext_Email(); //storing the generated Email value
        aUser.setText_Email_write_into(textEmail);
        aUser.setTtext_CellPhone("1234123412");
        aUser.clickOnSave();
        wTable.setDescEmail();

        //Test Logic, checking whather the searchEmail() method will return true(mail exist) or false(mail does not exist)
        Assert.assertTrue(wTable.searchEmail(driver, textEmail ));
    }

};





