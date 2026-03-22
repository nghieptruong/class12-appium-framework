package pages.ios;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.LoginPage;

public class IOSLoginPage extends LoginPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User Name\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    WebElement txtUserName;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    WebElement txtPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    WebElement btnLogin;

    public IOSLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void enterAccount(String accountName) {
        inputText(txtUserName, accountName);
    }

    @Override
    public void enterPassword(String password) {
        inputText(txtPassword, password);
    }

    @Override
    public void clickLoginButton() {
        click(btnLogin);
    }
}
