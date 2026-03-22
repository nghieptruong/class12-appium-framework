package pages.ios.components;

import constants.TimeOutConstants;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.components.NavigationBar;

public class IOSNavigationBar extends NavigationBar {

    @iOSXCUITFindBy(accessibility = "More-tab-item")
    WebElement mainMenu;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement lnkLoginMenuItem;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    WebElement lnkLogoutMenuItem;

    public IOSNavigationBar(WebDriver driver) {
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
