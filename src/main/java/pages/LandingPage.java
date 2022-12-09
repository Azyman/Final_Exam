package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage{

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Make Appointment')]")
    @CacheLookup
    WebElement make_appointment_btn;

    public void clickMakeAppointment(){
        make_appointment_btn.click();
    }

}
