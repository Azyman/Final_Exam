package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

    @FindBy(id = "combo_facility")
    @CacheLookup
    WebElement facility;

    @FindBy(xpath = "//input[@name='hospital_readmission']")
    @CacheLookup
    WebElement readmission_chk_box;

    @FindBy(id = "radio_program_medicare")
    @CacheLookup
    WebElement program_medicare;

    @FindBy(id = "radio_program_medicaid")
    @CacheLookup
    WebElement program_medicaid;

    @FindBy(id = "radio_program_none")
    @CacheLookup
    WebElement program_none;

    @FindBy(id = "txt_visit_date")
    @CacheLookup
    WebElement visit_date;

    @FindBy(id = "txt_comment")
    @CacheLookup
    WebElement comment_area;

    @FindBy(id = "btn-book-appointment")
    @CacheLookup
    WebElement book_appointment_btn;

    @FindBy(xpath = "//h2[contains(text(),'Make Appointment')]")
    @CacheLookup
    WebElement appointmentPageText;

    @FindBy(xpath = "//h2[contains(text(),'Appointment Confirmation')]")
    @CacheLookup
    WebElement appointmentConfirmationText;

    public AppointmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String appointmentConfirmation(){
        return appointmentConfirmationText.getText();
    }

    public String setAppointmentPageText(){
        return appointmentPageText.getText();
    }

    public void selectFacility(int index){
        Select facilities = new Select(facility);
        facilities.selectByIndex(index);
    }

    public void clickApplyForAdmission(){
        readmission_chk_box.click();
    }

    public void selectHealthProgram(){
        program_medicare.click();
    }

    public void selectVisitDate(String visit_date1){
        visit_date.sendKeys(visit_date1);
    }

    public void setComment(String comment){
        comment_area.sendKeys(comment);
    }

    public void clickBookAppointment(){
        book_appointment_btn.click();
    }


}
