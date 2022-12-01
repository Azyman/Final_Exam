package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTests extends BaseTests{
    @Test
    public void clickMakeAppointmentTest(){
        String landing_page_text = landingPage.get_image_text();
        Assert.assertEquals(landing_page_text,"CURA Healthcare Service");
        landingPage.clickMakeAppointment();
    }

}
