package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTests{
    public LoginPage loginPage;
    @Test(dataProvider = "loginCredentials")
    public void loginTest(String uname, String pword){
        loginPage = new LoginPage(driver);
        landingPage.clickMakeAppointment();
        Assert.assertEquals(loginPage.verifyLoginText(),"Please login to make appointment.");
        loginPage.login(uname, pword);
    }

    @DataProvider
    public static Object[][] loginCredentials(){
        Object[][] data = new Object[1][2];

        data[0][0] = "John Doe";
        data[0][1] = "ThisIsNotAPassword";

        return data;
    }
}
