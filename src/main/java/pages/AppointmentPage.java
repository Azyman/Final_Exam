package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

    @FindBy(id = "combo_facility")
    @CacheLookup
    WebElement facility;

    @FindBy(id = "chk_hospotal_readmission")
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

    public void selectFacility(int index){
        Select facilities = new Select(facility);
        facilities.selectByIndex(index);
    }

    public void clickApplyForAdmission(){
        readmission_chk_box.click();
    }

    public void selectHealthProgram(){

    }

}
