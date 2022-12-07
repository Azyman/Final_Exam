package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    @CacheLookup
    WebElement username_field;

    @FindBy(name = "password")
    @CacheLookup
    WebElement password_field;

    @FindBy(id = "btn-login")
    @CacheLookup
    WebElement login_button;

    @FindBy(xpath = "//p[@class='lead']")
    @CacheLookup
    WebElement login_page_text;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String verifyLoginText(){
        return login_page_text.getText();
    }

    public void login(String username, String password){
        username_field.sendKeys(username);
        password_field.sendKeys(password);
        login_button.click();
    }
}
