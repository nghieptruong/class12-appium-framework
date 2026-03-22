package pages.ios;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.HomePage;

public class IOSHomePage extends HomePage {

    @iOSXCUITFindBy(accessibility = "title")
    WebElement lblPageTitle;

    public IOSHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public String getTitle() {
        return getText(lblPageTitle);
    }
}
