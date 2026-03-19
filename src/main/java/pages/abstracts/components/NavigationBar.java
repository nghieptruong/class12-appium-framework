package pages.abstracts.components;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public abstract void clickMainMenu();

    public abstract void navigateToLoginPage();

    public abstract void clickLogOut();

    public abstract boolean isLogoutDisplayed();

}
