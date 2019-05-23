package pages.com.way2automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser extends BaseClass{


    @FindBy(xpath="//input[@name='FirstName']") WebElement field_FirstName;
    @FindBy(xpath="//input[@name='LastName']") WebElement field_LastName;
    @FindBy(xpath="//input[@name='UserName']") WebElement field_UserName;
    @FindBy(xpath="//input[@name='Password']") WebElement field_password;
    @FindBy(xpath="(//label[@class=\"radio ng-scope ng-binding\"])[1]") WebElement radio_Company;
    @FindBy(xpath="//select[@name = 'RoleId']") WebElement select_role;
    @FindBy(xpath="//input[@name = 'Email']") WebElement field_Email;
    @FindBy(xpath="//input[@name = 'Mobilephone']") WebElement field_CellPhone;
    @FindBy(xpath="//button[contains(text(), \"Save\")]") WebElement button_Save;

    //Constructor
    public AddUser(WebDriver driver) {
      super(driver);
    };

    public void setTtext_FirstName(String text) {
        setElementText(field_FirstName, text);
    };
    public void setTtext_LastName(String text) {
        setElementText(field_LastName, text);
    };
    public void setTtext_UserName(String text) {
        setElementText(field_UserName, text);
    };
    public void setTtext_Password(String text) {
        setElementText(field_password, text);
    };

    public String generateEmail() {
        return emailGenerator();
    };
    public void setText_Email(String text) {
       setElementText(field_Email, text);
    };


    public void setTtext_CellPhone(String text) {
        setElementText(field_CellPhone, text);
    };
    public void selectRole (String value){
        selectValueInDropdown(select_role, value);
    };
    public void selectCompany(){
        clickElement(radio_Company);
    };
    public void clickOnSave(){
        clickElement(button_Save);
    };


}
