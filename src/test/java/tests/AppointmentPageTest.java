package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;

public class AppointmentPageTest extends BaseTests{
    AppointmentPage appointmentPage;
    @Test(dataProvider = "facilities")
    public void submitAppointmentInfor(Integer index_local,String value,String visit_date,String comment) throws InterruptedException {

        LoginPage loginPage = new LoginPage(BaseTests.driver);
        landingPage.clickMakeAppointment();
        appointmentPage = new AppointmentPage(driver);
        loginPage.login("John Doe","ThisIsNotAPassword");

        Assert.assertEquals(appointmentPage.setAppointmentPageText(),"Make Appointment");

        appointmentPage.selectFacility(index_local);
        appointmentPage.clickApplyForAdmission();
        appointmentPage.setHealthcare_program(value,driver);
        appointmentPage.selectVisitDate(visit_date);
        appointmentPage.setComment(comment);
        Thread.sleep(3000);
        appointmentPage.clickBookAppointment();

        Thread.sleep(1000);
        Assert.assertEquals(appointmentPage.appointmentConfirmation(),"Appointment Confirmation");

    }

    @DataProvider(name = "facilities")
    public static Object[][] facilities(){
        Object[][] data = new Object[3][4];

        data[0][0] = 0;
        data[0][1] = "Medicare";
        data[0][2] = "12/12/2022";
        data[0][3] = "My first appointment with my doctor on 12/12/2022";

        data[1][0] = 1;
        data[1][1] = "Medicaid";
        data[1][2] = "15/12/2022";
        data[1][3] = "My second appointment with my doctor on 15/12/2022";

        data[2][0] = 2;
        data[2][1] = "None";
        data[2][2] = "20/12/2022";
        data[2][3] = "My third appointment with my doctor on 20/12/2022";

        return data;
    }
}
