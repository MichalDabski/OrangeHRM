package automationTests.pages;

import automationTests.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), 'credentials')]/p[text()[contains(.,'Username')]]")
    protected WebElement userNameValue;

    @FindBy(xpath = "//div[contains(concat(' ', @class, ' '), 'credentials')]/p[text()[contains(.,'Password')]]")
    protected WebElement passwordValue;

    @FindBy(xpath = "//input[@placeholder = 'Username']")
    protected WebElement txtUserName;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    protected WebElement txtPassword;

    @FindBy(xpath = "//button[@type ='submit']")
    protected WebElement btnLogIn;

    private final WebDriver driver;

    public LoginPage() {
        super();
        driver = DriverManager.getWebDriver();
        PageFactory.initElements(driver, this);
    }


    public LoginPage fillOutLoginData() {
        String username = userNameValue.getText().substring(11);
        String password = passwordValue.getText().substring(11);
        txtUserName.clear();
        txtUserName.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public Dashboard clickLogInButton() {
        btnLogIn.click();
        return new Dashboard();
    }

}

