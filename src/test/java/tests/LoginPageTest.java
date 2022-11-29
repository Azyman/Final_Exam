package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTests{


    @Test(dataProvider = "loginCredentials")
    public void login(String uname, String pword){
        LoginPage loginPage = new LoginPage(driver);
        landingPage.clickMakeAppointment();
        AppointmentPage login = loginPage.login(uname, pword);
    }

    @DataProvider
    public Object[][] loginCredentials(){
        Object[][] data = new Object[1][2];
        data[0][0] = "John Doe";
        data[0][1] = "ThisIsNotAPassword";
        return data;
    }

}
