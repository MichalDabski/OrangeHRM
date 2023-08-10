package automationTests.tests;

import automationTests.pages.Dashboard;
import automationTests.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(priority = 1, description = "Log in")
    public void login() {
        LoginPage loginPage = new LoginPage();
        Dashboard dashboard = new Dashboard();
        loginPage.fillOutLoginData().clickLogInButton();
        Assert.assertTrue(dashboard.isUserPanelDisplayed());
    }
}
