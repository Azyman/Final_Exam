package tests;

import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;


public class AppointmentPageTest extends BaseTests{

    @Test
    public void submitAppointmentInfor(){
        LoginPage loginPage = new LoginPage(BaseTests.driver);
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        landingPage.clickMakeAppointment();
        loginPage.verifyLoginText();
        loginPage.login("John Doe","ThisIsNotAPassword");
        appointmentPage.selectHealthProgram();
    }
}
