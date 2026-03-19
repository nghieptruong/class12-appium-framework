package pages.android.components;

import constants.TimeOutConstants;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.components.NavigationBar;

public class AndroidNavigationBar extends NavigationBar {

    @AndroidFindBy(accessibility = "View menu")
    WebElement mainMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
    WebElement lnkLoginMenuItem;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log Out\")")
    WebElement lnkLogoutMenuItem;

    public AndroidNavigationBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void clickMainMenu() {
        click(mainMenu);
    }

    @Override
    public void navigateToLoginPage() {
        click(lnkLoginMenuItem);
    }

    @Override
    public void clickLogOut() {
        click(lnkLogoutMenuItem);
    }

    @Override
    public boolean isLogoutDisplayed() {
        try {
            return waitVisibilityOf(lnkLogoutMenuItem, TimeOutConstants.DEFAULT_TIMEOUT).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
