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

    @FindBy(xpath = "//h1[contains(text(),'CURA Healthcare Service')]")
    WebElement landing_page_title;

    public void clickMakeAppointment(){
        make_appointment_btn.click();
    }

    public String get_image_text(){
       return landing_page_title.getText();
    }
}
