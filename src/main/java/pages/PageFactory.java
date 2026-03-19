package pages;

import drivers.DriverFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import pages.abstracts.components.NavigationBar;
import pages.android.AndroidHomePage;
import pages.android.AndroidLoginPage;
import pages.android.components.AndroidNavigationBar;
import pages.ios.IOSHomePage;
import pages.ios.IOSLoginPage;
import pages.ios.components.IOSNavigationBar;
import utils.PlatformUtils;

public class PageFactory {

    public static HomePage getHomePage() {
        if(PlatformUtils.isAndroid())
            return new AndroidHomePage(DriverFactory.getDriver());
        else
            return new IOSHomePage(DriverFactory.getDriver());
    }

    public static LoginPage getLoginPage() {
        if(PlatformUtils.isAndroid())
            return new AndroidLoginPage(DriverFactory.getDriver());
        else
            return new IOSLoginPage(DriverFactory.getDriver());
    }

    public static NavigationBar getNavigationPage() {
        if(PlatformUtils.isAndroid())
            return new AndroidNavigationBar(DriverFactory.getDriver());
        else
            return new IOSNavigationBar(DriverFactory.getDriver());
    }
}
