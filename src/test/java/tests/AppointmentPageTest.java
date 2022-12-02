package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;


public class AppointmentPageTest extends BaseTests{
    AppointmentPage appointmentPage;
    @Test(priority = 1)
    public void submitAppointmentInfor() throws InterruptedException {
        LoginPage loginPage = new LoginPage(BaseTests.driver);
        landingPage.clickMakeAppointment();
        loginPage.login("John Doe","ThisIsNotAPassword");
        appointmentPage = new AppointmentPage(driver);

        Assert.assertEquals(appointmentPage.setAppointmentPageText(),"Make Appointment");

        appointmentPage.selectFacility(2);
        appointmentPage.clickApplyForAdmission();
        appointmentPage.selectHealthProgram();// set this to accept index again so that we can pass same index as above
        appointmentPage.selectVisitDate("01/12/2022");
        appointmentPage.setComment("This is my first comment");
        Thread.sleep(3000);
        appointmentPage.clickBookAppointment();

        Thread.sleep(2000);
        Assert.assertEquals(appointmentPage.appointmentConfirmation(),"Appointment Confirmation");

    }
/*
    @Test(priority = 2)
    public void bookAppointment(){
        appointmentPage.selectFacility(0);
        appointmentPage.clickApplyForAdmission();
        appointmentPage.selectHealthProgram();// set this to accept index again so that we can pass same index as above
        appointmentPage.selectVisitDate("01/12/2022");
        appointmentPage.setComment("This is my first comment");
        appointmentPage.clickBookAppointment();
    }

    @DataProvider(name = "facilityData")
    public Object[][] facilities(){
        Object[][] data = new Object[1][3];
        data[0][0] = 0;
        data[0][1] = 1;
        data[0][2] = 2;
        return data;
    }
*/
}
