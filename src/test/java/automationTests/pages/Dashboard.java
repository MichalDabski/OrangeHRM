package automationTests.pages;

import automationTests.utilities.WaitUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends LoginPage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    protected WebElement dropdownUserPanel;

    @FindBy(xpath = "//span[text() ='Leave']")
    protected WebElement leavePanelButton;


    public boolean isUserPanelDisplayed() {
        WaitUtilities.waitUntilElementIsVisible(dropdownUserPanel, 5);
        boolean isDisplayed = dropdownUserPanel.isDisplayed();
        logger.info("");
        return isDisplayed;
    }

    public LeaveList gotoLeaveList() {
        WaitUtilities.waitUntilElementIsVisible(leavePanelButton, 5);
        leavePanelButton.click();
        return new LeaveList();
    }

}
