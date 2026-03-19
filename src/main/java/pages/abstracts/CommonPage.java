package pages.abstracts;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.PageFactory;
import pages.abstracts.components.NavigationBar;

public class CommonPage extends BasePage {

    private NavigationBar navigationBar;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.navigationBar = PageFactory.getNavigationPage();
    }

    public NavigationBar getNavigationBar() {
        return this.navigationBar;
    }
}
