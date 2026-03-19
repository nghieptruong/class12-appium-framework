package pages.ios.components;

import org.openqa.selenium.WebDriver;
import pages.abstracts.components.NavigationBar;

public class IOSNavigationBar extends NavigationBar {


    public IOSNavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMainMenu() {

    }

    @Override
    public void navigateToLoginPage() {

    }

    @Override
    public void clickLogOut() {

    }

    @Override
    public boolean isLogoutDisplayed() {
        return false;
    }
}
